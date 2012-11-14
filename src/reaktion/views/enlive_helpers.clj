(ns reaktion.views.enlive_helpers
  (:require [net.cgrand.enlive-html :as html]
            clojure.pprint))

(defn render [template]
  (apply str template))

(defmacro maybe-substitute
  ([expr] `(if-let [x# ~expr] (html/substitute x#) identity))
  ([expr & exprs] `(maybe-substitute (or ~expr ~@exprs))))

(defmacro maybe-content
  ([expr] `(if-let [x# ~expr] (html/content x#) identity))
  ([expr & exprs] `(maybe-content (or ~expr ~@exprs))))

(defmacro meta-tag [name content]
    [(and (html/has [:meta]) (html/attr-has :name name))] (html/set-attr :content content))

(html/deftemplate layout "reaktion/views/layout.html"
  [{:keys [title main]}]
  [:title]  (maybe-content title)
  ;;(meta-tag "description" title) Need help!
  [(and (html/has [:meta]) (html/attr-has :name "description"))] (html/set-attr :content title)
  [:div.main] (maybe-content main))

(html/defsnippet list-of-talks "reaktion/views/list_of_talks.html" [:div.talk-list]
  [{:keys [talks]}])

(defn talks [talks]
  (layout {:title "Talks"
           :main  (list-of-talks {:talks "foo"})}))