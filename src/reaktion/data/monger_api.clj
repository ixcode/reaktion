(ns reaktion.data.monger_api
  (:require [monger.collection :as mc])
  (:use [monger.core :only [connect! connect set-db! get-db]])
  (:import [org.bson.types ObjectId]
           [com.mongodb DB WriteConcern]))


(defn connect-mongo []
   (connect!)
   (set-db! (get-db "reaktion-test")))

(defn store-document [collection-name document]
  (let [oid (ObjectId.)]
    (mc/insert collection-name (merge document {:_id oid}))
    (str oid)))

(defn normalise-mongo-id [data]
  "Swaps _id for id in the map"
  (let [{:keys [_id]} data]
    (->
     (dissoc data :_id)
     (merge {:id (str _id)}))))

;;(normalise-mongo-id {:_id (ObjectId.) :jim "foo"})

(defn retrieve-document [collection-name id]
  (let [data (mc/find-map-by-id collection-name (ObjectId. id))]
    (let [])))


;; For heroku...
;;(mg/connect-via-uri! (System/genenv "MONGOHQ_URL"))

;;(mc/insert "mycollection" { :_id "509d887f3004e23034457a76" :first_name "John" :last_name "Lennon" })

;; (insert-batch "document" [{ :first_name "John" :last_name "Lennon" }
;;                           { :first_name "Paul" :last_name "McCartney" }])

;;(mc/find "mycollection" {:first_name "John"})
;;(mc/find-one "mycollection" {:first_name "John"})
;;(println (str  (:_id (mc/find-map-by-id "mycollection" (ObjectId. "509d887f3004e23034457a76")))))



