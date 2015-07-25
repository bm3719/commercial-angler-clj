;;;; This is a dev namespace to contain utility functions useful for
;;;; interacting with the data at the REPL, or for general development.
(ns user
  (:require [seesaw-test.core :as core]
            [seesaw.core :as sc]
            [seesaw.font :as sf]
            [clojure.repl :refer [doc]]
            [clojure.tools.namespace.repl :as repl]))
