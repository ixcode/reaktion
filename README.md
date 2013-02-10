# reaktion

A website written in noir. 

## Usage

If you use cake, substitute 'lein' with 'cake' below. Everything should work fine.

Leiningen is the clojure build system: https://github.com/technomancy/leiningen

You can do `brew install lein`

```bash
lein deps
lein run
```

## Monitoring

New relic

https://newrelic.com/docs/java/java-agent-installation
https://newrelic.com/docs/python/python-agent-and-heroku

Need somehow to get this:

:jvm-opts ["-javaagent:/app/ops/newrelic/newrelic.jar"]

into the lein run command

## Build

Travis CI

https://travis-ci.org/ixcode/reaktion

## Heroku setup

  $ heroku login

  $ heroku addons:add mongohq:sandbox --app reaktion
  $ heroku addons:add newrelic --app reaktion

  $ heroku create --stack cedar reaktion

  $ heroku git:remote -a reaktion

  $ git push heroku master

  $ heroku logs -t --app reaktion


## TODO

- Convert to using Ring
- Use Laser instead of enlive
- Get newrelic working on heroku (need to be able to parameterise the project.clj to set jvm-opts)
- Add complete API - Searching, events
- Add "events" i.e. dates for the event - link to the talks - can have feeds for current, past and future events
- Add an Ical integration to be able to add the calendar to google calendar
- Change README to ORG file
- Rename "index.clj" to views
- Restructure files to be more sensible
- Replace CSS with LESS?

## License

Copyright (C) 2011 FIXME

Distributed under the Eclipse Public License, the same as Clojure.

