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
  [{:keys [title body-class main]}]
  [:title]  (maybe-content title)
  ;;(meta-tag "description" title) Need help!
  [(and (html/has [:meta]) (html/attr-has :name "description"))] (html/set-attr :content title)
  [:body] (html/set-attr :class body-class)
  [:div.main] (maybe-content main))


(html/defsnippet _talk_item "reaktion/views/list_of_talks.html" [:ul.talks :> html/first-child]
  [{:keys [title speaker self speaker-img]}]
  [:a] (html/set-attr :href self)
  [:img] (html/do-> 
          (html/set-attr :src speaker-img)
          (html/set-attr :alt speaker)
          (html/set-attr :title speaker))
  [:span.title] (html/content title)
  [:span.author] (html/content speaker))

(html/defsnippet _list-of-talks "reaktion/views/list_of_talks.html" [:div.talk-list]
  [talks]
  [:ul.talks] (html/content (map _talk_item talks)))

(defn talks [talks]
  (layout {:title "Talks"
           :body-class "list-view"
           :main  (_list-of-talks talks)}))


(html/defsnippet _reakt-to-a-talk "reaktion/views/reakt_to_a_talk.html" [:div.talk]
  [{:keys [id speaker speaker-img self title]}]
  [:div.speaker :> :img] (html/set-attr :alt speaker)
  [:div.speaker :> :img] (html/set-attr :src speaker-img)
  [:div.speaker :> :img] (html/set-attr :title speaker)
  [:div.speaker :> :h1] (maybe-content title)
  [:div.speaker :> :p] (maybe-content speaker)
  [(and (html/has [:input]) (html/attr-has :name "talk"))] (html/set-attr :value id)
  [:form] (html/set-attr :action self))


(defn talk-reaktion [talk]
  (layout {:title "Reakt!"
           :body-class "talk-view"
           :main (_reakt-to-a-talk talk)}))

(html/defsnippet _thanks "reaktion/views/thanks.html" [:div.thanks]
  [])

(defn feedback-accepted []
  (layout {:title "Feedback accepted"
           :body-class "thanks-view"
           :main (_thanks)}))