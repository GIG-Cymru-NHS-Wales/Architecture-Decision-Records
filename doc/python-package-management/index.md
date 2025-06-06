# Python Package Management

!!! info

    **Status**: Proposed
    
    **Level**: 2

    **Updated**: 2025-06-04

## Summary

Python projects require effective dependency and virtual environment management
to ensure reproducibility, reliable dependency resolution, and efficient
development workflows. This ADR evaluates and recommends tooling for managing
Python packages and environments across projects, with a focus on
reproducibility, ease of use, and maintainability.

## Drivers

We need to standardise Python package management tooling because:

* Current ad-hoc approach leads to inconsistent environments and dependency conflicts
* Multiple tools in use create confusion and maintenance overhead
* Need for reproducible builds and deterministic environments across CI/CD
* Requirements for fast, reliable dependency resolution
* Need for lock file support to ensure consistent environments
* Development experience needs improvement with simpler workflows

Our key priorities are:

1. Reproducibility: Guaranteed consistent environments via lock files
2. Developer Experience: Simple CLI, minimal config, efficient workflows
3. CI/CD Compatibility: Works well with our deployment pipelines
4. Community Support: Mature tooling with good documentation
5. Performance: Fast dependency resolution and installation

## Options

We evaluated these popular Python package management tools:

* [`uv`](https://github.com/astral-sh/uv) - Modern, fast package installer and resolver
* [`poetry`](https://python-poetry.org/) - Comprehensive Python packaging tool
* [`pip + venv + pip-tools`](https://pip.pypa.io/) - Standard Python tooling
* [`pipenv`](https://pipenv.pypa.io/) - Unified dependency management
* [`conda`](https://docs.conda.io/) - Cross-platform package manager
* [`hatch`](https://hatch.pypa.io/) - Modern project management tool

## Options Analysis

### `uv` Analysis

**Pro:**

* Extremely fast performance (Rust implementation)
* Full pyproject.toml support with lock file generation
* Drop-in replacement for pip and pip-tools
* Compatible with existing Poetry and pip lock files
* Combined environment and dependency management

**Con:**

* Newer tool with evolving feature set
* Limited plugin ecosystem currently

### `poetry` Analysis

**Pro:**

* Complete solution for dependency management and publishing
* Mature tool with extensive documentation
* Strong lock file support and reproducibility
* Native pyproject.toml support

**Con:**

* Complex configuration for monorepos
* Strict/opinionated approach limits flexibility
* Slower dependency resolution

### `pip + venv + pip-tools` Analysis

**Pro:**

* Standard Python ecosystem tools
* Maximum flexibility and control
* Lightweight, no external dependencies
* Universal compatibility (CI, Docker, legacy systems)

**Con:**

* Manual setup process prone to errors
* Requires multiple tools working together (e.g. for lockfile management)
* Slower dependency resolution
* Poor developer experience for larger projects

### `pipenv` Analysis

**Pro:**

* Combined environment and dependency management
* User-friendly command line interface
* Creates lockfiles and manages `Pipfile`

**Con:**

* Declining maintenance and community support
* Slower and inconsistent dependency resolution
* No pyproject.toml support

### `conda` Analysis

Overall: I love conda and it's great for AI/ML work, but didn't play well with
other kinds of python projects such as Django apps and Flask services.

**Pro:**

* Excellent for data science/ML dependencies
* Fast binary package installation
* Handles non-Python dependencies well

**Con:**

* Not standard for Python-only projects
* Large environment footprint
* Limited lock file capabilities

### `hatch` Analysis

**Pro:**

* Modern `PEP 517/518` compliant tooling
* Strong environment management
* Good for Python packaging and monorepos

**Con:**

* Smaller community and adoption
* May be excessive for basic dependency management
* Limited evaluation due to newer adoption

## Recommendation

We recommend adopting `uv` as the standard Python package management tool for
projects.

The decision is based on:

* Superior performance and reliability compared to alternatives
* Strong support for modern Python packaging standards
* Excellent lock file support ensuring reproducibility
* Simple drop-in replacement for existing tools
* Growing community adoption and active development

### Consequences

**Pro:**

* Significant performance improvements in CI/CD
* Simplified developer workflows
* Better reproducibility via reliable lock files

**Con:**

* Some learning curve for teams used to other tools
* May need to maintain compatibility with legacy projects using other tools

### Confirmation

Implementation will be verified through:

* Updated project templates using `uv`
* CI/CD pipeline updates to standardize on `uv`
* Team documentation and training
* Monitoring of build times and dependency resolution issues

## More Information

Special cases:

* Teams working with data science/ML projects may continue using conda if required
* Legacy projects may maintain existing tools until convenient migration points

This decision should be reviewed in 12 months to assess:

* Community adoption of `uv`
* Team feedback and pain points
* New alternatives in the Python packaging ecosystem
