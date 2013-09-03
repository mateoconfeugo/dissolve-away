(ns dissolve-away-host.handler
  (:require  [dissolve-away.handler])
  (:use  [ring.adapter.jetty :as ring :only[run-jetty]])
  (:gen-class))

(def app dissolve-away.handler/app)

(defn start [port] (ring/run-jetty app {:port port :join? false}))

(defn -main []
  (let [port (Integer/parseInt (or (System/getenv "MGNT_PORT") "8087"))]
    (start port)))
