(defproject commercial-angler-clj "0.1.0-SNAPSHOT"
  :description "A commercial fishing simulator."
  :url "http://macroexpand.com/~bm3719/angler.html"
  :license {:name "BSD 3-clause License"
            :url "http://opensource.org/licenses/BSD-3-Clause"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [seesaw "1.4.5"]]
  :main commercial-angler-clj.core
  :repl-options {:init-ns user}
  :global-vars {*print-length* 100}
  :profiles {:dev {:resource-paths ["dev"]
                   :dependencies [[org.clojure/tools.namespace "0.2.10"]]}
             :uberjar {:aot :all}})
