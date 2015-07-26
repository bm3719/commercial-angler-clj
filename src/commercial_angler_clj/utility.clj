(ns commercial-angler-clj.utility
  (:require [clojure.string :as s]))

(defn str->int
  "Safely parse untrusted strings to ints." [str]
  (when (re-matches (re-pattern "^[-+]?\\d+") str) (read-string str)))

(defn str->decimal
  "Safely parse untrusted strings to decimals.  Requires a \".\" character.
  For the purposes of this program, only 2 decimal places are accepted." [str]
  (when (re-matches (re-pattern "^[-+]?\\d+(\\.\\d{1,2})") str) (read-string str)))

(defn apply-schema
  "Applies a data schema to a record." [schema record]
  {:pre [(= (set (apply concat (map keys schema)))
            (set (keys record)))]}
  (let [schema (into {} schema)]
    (->> (for [key (keys schema)
               :let [f (resolve (key schema))]]
           [key (f (key record))])
         (apply concat)
         (apply assoc schema))))

(defn ingest-data
  "Ingest a data file, which is a CSV file with commented lines starting with
  \"#\"." [file schema]
  (as-> (slurp file) $
    (s/split $ #"\n")
    (filter #(not (re-matches #"#.*" %)) $)
    (map #(s/split % #",") $)
    (map #(zipmap (apply concat (map keys schema)) %) $)
    (map #(apply-schema schema %) $)
    (vec $)))
