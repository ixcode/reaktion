(ns reaktion.data.monger_api
  (:require [monger.collection :as mc])
  (:use [monger.core :only [connect! connect set-db! connect-via-uri! get-db]])
  (:import [org.bson.types ObjectId]
           [com.mongodb DB WriteConcern]))


(defn connect-mongo! []
  (println "!!!!!!" (System/getenv "MONGOHQ_URL"))
  (let [mongohq_url (System/getenv "MONGOHQ_URL")]
    (if (nil? mongohq_url)
      (connect!)
      (connect-via-uri! mongohq_url)))
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

(defn retrieve-collection [collection-name query]
  (map normalise-mongo-id (mc/find-maps collection-name query)))

(defn retrieve-document [collection-name id]
  (let [data (mc/find-map-by-id collection-name (ObjectId. id))]
    (println data)))






