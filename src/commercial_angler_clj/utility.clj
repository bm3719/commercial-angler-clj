(ns commercial-angler-clj.utility
  (:require [lock-key.core :as lk]
            [clojure.string :as s]))

(defn str->int
  "Safely parse untrusted strings to ints." [str]
  (when (re-matches (re-pattern "^[-+]?\\d+") str) (read-string str)))

(defn str->decimal
  "Safely parse untrusted strings to decimals.  Requires a \".\" character.
  For the purposes of this program, only 2 decimal places are accepted." [str]
  (when (re-matches (re-pattern "^[-+]?\\d+(\\.\\d{1,2})") str)
    (read-string str)))

(def crypt-key "k95ja7d1jv09lauw")

(defn write-file
  "Write string data to an encrypted file.  Will first encrypt data."
  [s file]
  (spit file (lk/encrypt-as-base64 s crypt-key)))

(defn read-file
  "Read in an encrypted file and decrypt its contents." [file]
  (lk/decrypt-from-base64 (slurp file) crypt-key))

(defn apply-schema
  "Applies a schema to a record." [schema record]
  {:pre [(= (set (apply concat (map keys schema)))
            (set (keys record)))]}
  (let [schema (into {} schema)]
    (->> (for [key (keys schema)
               :let [f (resolve (key schema))]]
           [key (f (key record))])
         (apply concat)
         (apply assoc schema))))

(defn ingest-data
  "Ingest a data file using a schema.  file is a CSV file with commented lines
  starting with \"#\".  schema is a vector of single key/value pairs, with the
  value being a transform function symbol." [file schema]
  (as-> (read-file file) $
    (s/split $ #"\n")
    (filter #(not (re-matches #"#.*" %)) $)
    (map #(s/split % #",") $)
    (map #(zipmap (apply concat (map keys schema)) %) $)
    (map #(apply-schema schema %) $)
    (vec $)))

(def character-schema
  [{:name 'identity}
   {:money 'str->int}
   {:weapon 'str->int}
   {:ship 'str->int}])

(defn save-game
  "Writes character data to a file.  Should only be callable while in port,
  since it doesn't save character position or fight status." [character file]
  (write-file
   (let [keys (apply concat (map keys character-schema))]
     (s/join "," (for [key keys] (key character))))
   file))

(defn load-game
  "Loads a saved character state from file." [file]
  (ingest-data file character-schema))
