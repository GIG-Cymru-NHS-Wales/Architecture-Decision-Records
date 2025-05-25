# Python pacakage management

!!! note
    Work in Progress

**Status**: first sketch, work in progress, request for collaboration

**Date**: Updated 2025-05-25

**Governance**: To Be Discovered; potentially a combo of this repo partipants, DHCW CISO, NHS Wales UCB peers, etc.

## Context

Effective management of Python dependencies and virtual environments is critical
for project reproducibility, dependency resolution, performance, and ease of
use. The team must select a tool or a combination of tools to handle:

* Dependency resolution
* Environment isolation
* Reproducible builds
* Lock file generation
* Speed and scalability
* Compatibility with CI/CD

We aim to evaluating these tools and possibly others, as time lets us:

* [`uv`](https://github.com/astral-sh/uv)
* [`poetry`](https://python-poetry.org/)
* [`pip`](https://pip.pypa.io/)
* [`venv`](https://docs.python.org/3/library/venv.html)
* [`pipenv`](https://pipenv.pypa.io/)
* [`conda`](https://docs.conda.io/en/latest/)
* [`hatch`](https://hatch.pypa.io/)

## Decision Drivers

Priority order:

* **Reproducibility**: Lockfiles and deterministic environments
* **Ease of use**: Clean CLI, minimal configuration, dev experience
* **Compatibility**: Works well with popular tools and CI/CD systems
* **Community and support**: Maturity, documentation, adoption
* **Performance**: Fast dependency resolution and installation

## Assessment

Joel's assessments.

### 1. `uv`

Overall: superb software engineering, bulletproof reliable, and successfully
replaced poetry on my most-recent client's python project.

* **Pros**:

  * Extremely fast (written in Rust)
  * Full support for `pyproject.toml`
  * Handles dependency resolution and installation
  * Lock file support (compatible with Poetry and pip)
  * Drop-in replacement for `pip` and `pip-tools`

* **Cons**:

  * Newer and still evolving
  * Fewer plugins and integrations

### 2. `poetry`

Summary: a chaotic mess that's caused severe team problems.

* **Pros**:

  * All-in-one: builds, dependency resolution, publishing
  * Mature and well-documented
  * Excellent lock file support
  * Native `pyproject.toml` management
  * Strong community and plugin ecosystem

* **Cons**:

  * Complicated for monorepos or nonstandard workflows
  * Can be strict or opinionated (e.g., editable installs)
  * Slower resolution performance

### 3. `pip + venv + pip-tools`

Overall: formally correct, but many too many moving pieces.

* **Pros**:

  * Fully standard and supported by Python ecosystem
  * Maximum control and transparency
  * Lightweight, no external dependencies
  * Works everywhere (CI, Docker, legacy systems)
  
* **Cons**:

  * Manual and error-prone setup
  * No built-in lockfile management (requires `pip-tools`)
  * Slower dependency resolution
  * Poor UX for larger projects

### 4. `pipenv`

Overall: it's sunsetting so not viable long term.

* **Pros**:

  * Combined env + dependency management
  * User-friendly CLI
  * Creates lockfiles and manages `Pipfile`

* **Cons**:

  * Falling out of favor; less actively maintained
  * Slower and sometimes inconsistent resolution
  * Does not use `pyproject.toml`

### 5. `conda`

Overall: I love conda and it's great for AI/ML work, but didn't play well with
other kinds of python projects such as Django apps and Flask services.

* **Pros**:

  * Cross-language dependency management (great for data science)
  * Binary packages = faster installs
  * Excellent for managing non-Python deps (e.g., OpenCV, MKL)

* **Cons**:

  * Not standard in Python-only ecosystems
  * Environments are larger and less portable
  * Lockfile support not as robust as pip/poetry

### 6. `hatch`

Overall: I haven't looked at this yet.

* **Pros**:

  * Modern, PEP 517/518 compliant
  * Strong environment management
  * Good for Python packaging and monorepos

* **Cons**:

  * Smaller community
  * Still growing adoption
  * May be overkill if only dependency management is needed

## Decision

Choose uv.
