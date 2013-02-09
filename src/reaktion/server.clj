(ns reaktion.server
  (:use compojure.core compojure.route ring.adapter.jetty)
  (:require
    [compojure.handler :as handler]
    [compojure.route :as route]
    [reaktion.data.monger_api :as mongo]
    [reaktion.views.index :as views]
    )
  )



(defroutes app
  (GET "/" [:as {server :server-name port :server-port}] (views/index server port))
  (GET "/talks" [:as {server :server-name port :server-port}] (views/talks server port))
  (GET "/talks/:id/feedback" [id :as {server :server-name port :server-port}] (views/talk_feedback id server port))
  (GET "/talks/:id" [id :as {server :server-name port :server-port}] (views/talk_feedback_form id server port))
  (GET "/feedback-accepted" [] (views/feedback_accepted))
  (GET "/ping" [:as request] (views/ping request))
  (POST "/talks/:id" [id :as {params :params}] (views/save_feedback params))
  (route/resources "/")
  (route/not-found "Not Found")
  )

(defn -main [& m]
  (let [mode (keyword (or (first m) :dev ))
        port (Integer. (get (System/getenv) "PORT" "8084"))]
    (println (System/getProperty "sun.java.command"))
    (println (format "PORT: %s" port))
    (println (format "MONGOHQ_URL: %s" (System/getenv "MONGOHQ_URL")))
    (mongo/connect-mongo!)
   (run-jetty (handler/site app) {:port port})
    )
)

