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

## Heroku setup

  $ heroku login

  $ heroku addons:add mongohq:sandbox --app reaktion

  $ heroku create --stack cedar reaktion

  $ heroku git:remote -a reaktion

  $ git push heroku master

  $ heroku logs -t --app reaktion

## License

Copyright (C) 2011 FIXME

Distributed under the Eclipse Public License, the same as Clojure.

