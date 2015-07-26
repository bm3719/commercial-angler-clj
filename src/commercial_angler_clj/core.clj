(ns commercial-angler-clj.core
  (:require [commercial-angler-clj.data :as data]
            [commercial-angler-clj.gui :as gui]
            [commercial-angler-clj.utility :as utility]
            [seesaw.core :as sc]
            [seesaw.font :as sf]
            [clojure.repl :refer [doc]]
            [clojure.string :as s]
            [clojure.tools.namespace.repl :as repl]))

(defn -main
  "Main application entry function." [& args]
  (sc/native!)
  (-> gui/game-frame sc/pack! sc/show!))
