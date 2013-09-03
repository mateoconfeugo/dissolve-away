(ns cms.api.common
  (:require [cheshire.core :as json]            
            [clojure.string :refer (join)]
            [clojure.walk :refer (keywordize-keys)]
            [liberator.representation :refer (ring-response)]
            [taoensso.timbre :refer (debug info warn error fatal spy)]))

(def UTF8 "utf-8")

(def malformed true)
(def good-json false)

(defn only-accept [media-type]
  (format "Acceptable media type: %s\nAcceptable char set: %s" media-type UTF8))

(def missing-collection-response
  (ring-response
    {:status 404
     :body "Collection not found."
     :headers {"Content-Type" "text/plain"}}))

(defn location-response [path-parts body media-type]
  (ring-response
    {:body body
     :headers {"Location" (format "/%s" (join "/" path-parts))
               "Content-Type" (format "%s;charset=%s" media-type UTF8)}}))

(defn malformed-json?
  "Read in the body param from the request as a string, parse it into JSON, make sure all the
  keys are keywords, and then return it, mapped to :data as the 2nd value in a vector,
  with the first value indicating it's not malformed. Otherwise just indicate it's malformed."
  [ctx]
  (try 
    (if-let [data (-> (get-in ctx [:request :body]) slurp (json/parse-string true))]
      [good-json {:data data}]
      malformed)
    (catch Exception e
      (debug "Request body not processable as JSON: " e)
      malformed)))