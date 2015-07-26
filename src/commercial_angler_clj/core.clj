(ns commercial-angler-clj.core
  (:require [commercial-angler-clj.utility
             :refer [str->int str->decimal] :as utility]
            [seesaw.core :as sc]
            [seesaw.font :as sf]
            [clojure.repl :refer [doc]]
            [clojure.string :as s]
            [clojure.tools.namespace.repl :as repl]))

(def fish-schema
  [{:id 'str->int}
   {:name 'identity}
   {:level 'str->int}
   {:base-hp 'str->int}
   {:min-dmg 'str->int}
   {:max-dmg 'str->int}
   {:ac 'str->int}
   {:weight 'str->int}
   {:value 'str->decimal}])

(def vessels-schema
  [{:id 'str->int}
   {:name 'identity}
   {:price 'str->int}
   {:hold-cap 'str->int}
   {:ship-hp 'str->int}
   {:ac 'str->int}])

(def weapons-schema
  [{:id 'str->int}
   {:name 'identity}
   {:price 'str->int}
   {:min-dmg 'str->int}
   {:max-dmg 'str->int}
   {:weight 'str->int}
   {:hit-bonus 'str->int}])

(defn -main
  "Main application entry function." [& args]
  (println "Hello, Fish!"))
