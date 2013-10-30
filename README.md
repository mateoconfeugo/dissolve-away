# Web site wrapper

Deployment wrapper app for the website.  The guts of the website are in a s3 private repository.  
This is a demostration for a continuous delivery style of deployment that allows the use of 
free github repo and private amazon s3 repos together.

## Prerequisites

You will need [Leiningen][1] 2.0 or above installed.

[1]: https://github.com/technomancy/leiningen

## Running

To start a web server for the application, run:

    lein ring server

## License

Copyright © 2013 Matt Burns
