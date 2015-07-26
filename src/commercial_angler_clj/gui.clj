(ns commercial-angler-clj.gui
  (:require [seesaw.core :as sc]))

;;; Menubar

(def new-action (sc/action :name "New Game"))
(def quickstart-action (sc/action :name "Quick Start"))
(def load-action (sc/action :name "Load Game"))
(def save-action (sc/action :name "Save Game"))
(def exit-action (sc/action :name "Exit"))
(def about-action (sc/action :name "About"))

;; Frames

(def game-frame
  (sc/frame :id 'game
            :title "Commercial Angler v0.2"
            :size [640 :by 470]
            :minimum-size [640 :by 470]
            ;; :icon ""                 ; TODO: Copy over icon.
            :menubar (sc/menubar :items
                                 [(sc/menu :text "File" :items
                                           [new-action quickstart-action load-action
                                            save-action exit-action])
                                  (sc/menu :text "Help" :items
                                           [about-action])])
            ))
