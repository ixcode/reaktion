(ns reaktion.views.components 
  (:use compojure.core
        hiccup.def
        hiccup.element))

(defn label-from-id [id]
  (-> 
   (clojure.string/replace id "-" " ")
   (clojure.string/capitalize)))


(defn choice-image [name value src text]
  (let [id (format "%s-%s" name value)]
       [:label {:for id}
        [:input {:id id :type "radio" :name name :value value}]
        [:img.choice {:src src}] text]))


(defn radio-button [id name value]  
  [:input {:id name :type "radio" :name name :value value}])

(defn rating-radio-button [question-id value]
  (let [element-id (format "%s_%s" (clojure.string/replace question-id "-" "_") value)]
    (radio-button element-id (clojure.string/replace question-id "-" "_") value)))

(defn rating-question [question-id]
  [:p.rating-question
   [:span.label (label-from-id question-id)]
   [:span.low "low"]
   (rating-radio-button question-id "01")
   (rating-radio-button question-id "02")
   (rating-radio-button question-id "03")
   (rating-radio-button question-id "04")
   (rating-radio-button question-id "05")
   [:span.high "high"]])

(defn comment-box [title, name]
  [:div.comment-box
   [:label title [:textarea.comments {:name name}]]])

(defn email-question [id]
  [:div.email-question
   [:label (label-from-id id) [:input {:type "text" :name (clojure.string/replace id "-" "_")}]]])
