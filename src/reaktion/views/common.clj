(ns reaktion.views.common
  (:use [noir.core :only [defpartial]]
        [hiccup.page :only [include-css html5]]))

(defpartial layout [params & content]
            (html5
              [:head
               [:title (:title params)]
               (include-css "/css/site.css")]
              [:body
               [:div#wrapper
                content]]))
