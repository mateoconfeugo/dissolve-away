(defproject dissolve-way-host "0.1.0"
  :description "The hosting release wrapper"
  :url "http://marketwithgusto.com/mgnt/about/development.html"
  :license {:name "MIT License" :url "http://opensource.org/licenses/MIT"}  
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.5.1"]  ; Lisp on the JVM  
                 [dissolve-away "0.1.0"]
                 [ring/ring-jetty-adapter "1.2.0"]]
  :plugins [[lein-ring "0.8.2"]
            [s3-wagon-private "1.1.2"]
            [lein-expectations "0.0.7"]
            [lein-autoexpect "0.2.5"]]
  :main dissolve-away-host.handler    
  :ring {:handler dissolve-away-host.handler/app}
  :repositories [["private" {:url "s3p://marketwithgusto.repo/releases/"
                             :username :env
                             :passphrase :env}]]
  :profiles  {:dev {:dependencies [[ring-mock "0.1.3"]
                                   [ring/ring-devel "1.1.8"]
                                   [clj-webdriver "0.6.0"]                 
                                   [expectations "1.4.33"]]}}
  :mailing-list {:name "management gui dev mailing list"
                 :archive "http://marketwithgusto.com/mgmt-gui-mailing-list-archives"
                 :other-archives ["http://marketwithgusto.com/mgmt-gui-list-archive2"
                                  "http://marketwithgusto.com/mgmt-gui-list-archive3"]
                 :post "list@marketwithgusto.com"
                 :subscribe "list-subscribe@marketwithgusto.com"
                 :unsubscribe "list-unsubscribe@marketwithgusto.com"})

