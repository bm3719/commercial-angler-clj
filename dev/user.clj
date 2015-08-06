;;;; This is a dev namespace to contain utility functions useful for
;;;; interacting with the data at the REPL, or for general development.
(ns user
  (:require [commercial-angler-clj.core :as core]
            [commercial-angler-clj.data :as data]
            [commercial-angler-clj.utility :refer [str->int str->decimal] :as utility]
            [seesaw.core :as sc]
            [seesaw.font :as sf]
            [clojure.repl :refer [doc]]
            [clojure.string :as s]
            [clojure.tools.namespace.repl :refer [refresh]]))

(defn unpack-data
  "Unencrypt and write the .dat files to .csv files for editing/viewing." []
  (for [file  ["fish" "vessels" "weapons"]
        :let [infile (str "resources/" file ".dat")
              outfile (str "resources/" file ".csv")]]
    (spit outfile (utility/read-file infile))))

(defn pack-data
  "Encrypt and write the .csv files to .dat files.  Run unpack-data first since
  these aren't stored unpacked." []
  (for [file  ["fish" "vessels" "weapons"]
        :let [infile (str "resources/" file ".csv")
              outfile (str "resources/" file ".dat")]]
    (utility/write-file outfile (slurp infile))))
