(ns reaktion.server
  (:require [noir.server :as server]
            [reaktion.data.monger_api :as mongo]))

(server/load-views-ns 'reaktion.views)

(defn -main [& m]
  (let [mode (keyword (or (first m) :dev ))
        port (Integer. (get (System/getenv) "PORT" "8080"))]
    (mongo/connect-mongo!)
    (server/start port {:mode mode
                        :ns 'reaktion})))

