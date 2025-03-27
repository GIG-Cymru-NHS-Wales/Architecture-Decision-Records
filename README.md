# GIG Cymru NHS Wales - Architecture Decision Records

An Architecture Decision Record (ADR) is a document that captures an important architecture decision made along with its context and consequences.

## Introduction

* [Why write architecture decision records - By GitHub Engineering](https://github.blog/engineering/architecture-optimization/why-write-adrs/)

* [A practical overview on Architecture Decision Records: How to start and why this could be your most valuable action as a software architect](https://ctaverna.github.io/adr/)

## Documentation

Our records are published using [Mkdoc Material](https://squidfunk.github.io/mkdocs-material/).

### Building Docs with Make

If you are a developer, or you want to generate documentation on your own system, then you can use the command `make`.

To see options for the command `make`:

```sh
make help
```

### Building Docs Manually

Install 'uv' for Python package/env management e.g. :

```bash
curl -LsSf https://astral.sh/uv/install.sh | sh
```

Setup the local environment and install dependencies:

```bash
uv sync
```

Run mkdocs locally:

```bash
uv run mkdocs serve
```

Navigate to ``http://127.0.0.1:8000/``

## License

This repository is licensed under the [MIT License](LICENSE)