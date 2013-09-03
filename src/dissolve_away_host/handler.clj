(ns dissolve-away-host.handler
  (:require  [dissolve-away.handler :refer [war-handler]]
             [ring.adapter.jetty :as ring :refer [run-jetty]])
  (:gen-class))

(defn start [port] (ring/run-jetty war-handler {:port port :join? false}))

(defn -main []
  (let [port (Integer/parseInt (or (System/getenv "DISSOLVE_AWAY_PORT") "8087"))]
    (start port)))
