This repo contains the asciidoctor files that make up the book which can be found at https://serenity-bdd.github.io/theserenitybook/latest/index.html 

# Contributing
You can add an improve on this documentation. To build the site locally:

    # create a folder to hold both required repositories
    mkdir $project-root
    cd $project-root
    
    # clone
    git clone https://github.com/serenity-bdd/serenity-docs
    git clone https://github.com/serenity-bdd/the-serenity-book
    
    # build the book from your local sources, requires antora: https://antora.org/
    cd serenity-docs
    antora generate --clean local.yml
    
    # open your browser at ./build/site-local/theserenitybook/2.1.4/index.html