(ns commercial-angler-clj.data
  (:require [commercial-angler-clj.utility
             :refer [str->int str->decimal] :as utility]))

(def fish
  (utility/ingest-data
   "resources/fish.dat"
   [{:id 'str->int}
    {:name 'identity}
    {:level 'str->int}
    {:base-hp 'str->int}
    {:min-dmg 'str->int}
    {:max-dmg 'str->int}
    {:ac 'str->int}
    {:weight 'str->decimal}
    {:value 'str->decimal}]))

(def vessels
  (utility/ingest-data
   "resources/vessels.dat"
   [{:id 'str->int}
    {:name 'identity}
    {:price 'str->int}
    {:hold-cap 'str->decimal}
    {:ship-hp 'str->int}
    {:ac 'str->int}]))

(def weapons
  (utility/ingest-data
   "resources/weapons.dat"
   [{:id 'str->int}
    {:name 'identity}
    {:price 'str->int}
    {:min-dmg 'str->int}
    {:max-dmg 'str->int}
    {:weight 'str->int}
    {:hit-bonus 'str->int}]))

(defn get-by-id
  "Retrieve an element from a dataset by id." [ds id]
  {:pre [(= (type id) Long)]}
  (some #(when (= (:id %) id) %) ds))
