(defproject reaktion "0.1.0-SNAPSHOT"
            :description "FIXME: write this!"
            :dependencies [
                           [org.clojure/clojure "1.4.0"]
                           [com.novemberain/monger "1.3.4"]
                           [ring/ring-jetty-adapter "1.1.7"]
                           [compojure "1.1.5"]
                           [lib-noir "0.3.5"]
                           [enlive "1.0.1"]
                         ]
            :min-lein-version "2.0.0"
            :main reaktion.server)

