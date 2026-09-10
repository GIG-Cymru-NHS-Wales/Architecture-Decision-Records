# Migrate from Make to Just for Command Running

!!! info

    **Status**: Accepted

    **Level**: 1

    **Updated**: 2025-11-16

## Summary

This ADR documents the decision to migrate from GNU Make to Just as the project's command runner. Just is a modern, cross-platform command runner designed specifically for saving and executing project-specific commands, while Make was originally designed as a build system. This migration simplifies our development workflow and improves the developer experience across different operating systems.

!!! note
    In this ADR the term "project" refers specifically to the backend of the "Architecture" documentation site — i.e. this repository on GitHub that
    contains these documents — and not to other unrelated projects.

## Drivers

* We are using Make solely as a command runner, not as a build system, which is not its primary design purpose.
* Make's syntax and behavior can be inconsistent across different platforms (Linux, macOS, Windows), leading to potential issues for contributors using different operating systems.
* The need for `.PHONY` declarations in our `Makefile` adds unnecessary boilerplate for a simple command runner.
* Just provides better error messages with source context, making it easier to debug issues in command definitions.
* Just offers a more intuitive syntax for developers who are not familiar with Make's build-system-oriented features.
* Cross-platform support is increasingly important as our team grows and uses diverse development environments.

## Options

### Option 1: Continue Using GNU Make

Make is a well-established build automation tool that has been used for decades. It uses a `Makefile` to define targets (recipes) and their dependencies.

**Key characteristics:**

* Widely known and available on most Unix-like systems
* Requires `.PHONY` declarations for non-file targets
* Complex syntax with implicit rules and pattern matching designed for build systems
* Platform-specific behavior differences (GNU Make vs BSD Make)
* Primarily designed for building software, not running arbitrary commands

### Option 2: Migrate to Just

Just is a modern command runner created by Casey Rodarmor. It's designed specifically for saving and running project-specific commands with a syntax inspired by Make but simplified for command execution.

**Key characteristics:**

* Simple, intuitive syntax focused on command execution
* No `.PHONY` declarations needed
* Excellent cross-platform support (Linux, macOS, Windows, and other Unix-like systems)
* Better error messages with source context
* Can be invoked from any subdirectory of the project
* Static error checking catches issues before execution
* Backward compatibility commitment (no breaking 2.0 planned)

### Option 3: Use npm/package.json Scripts

Leverage npm's script running capabilities through package.json, since the project already uses npm for markdownlint-cli2.

**Key characteristics:**

* Already have npm as a dependency
* Simple key-value script definitions
* Limited to Node.js/npm ecosystem
* Less flexible for complex command sequences

### Option 4: Create Shell Scripts

Write individual shell scripts for each command in a `scripts/` directory.

**Key characteristics:**

* No additional dependencies
* Familiar to most developers
* Requires managing multiple files
* No central help/list functionality
* Platform-specific (bash vs. PowerShell)

## Options Analysis

### Option 1 Assessment: Continue Using GNU Make

**Pro:**

* Already in use; no migration effort required
* Familiar to many developers
* Available by default on most Unix-like systems
* Extensive documentation and community knowledge

**Con:**

* Designed for building software, not as a command runner - we're using it outside its intended purpose
* Requires `.PHONY` declarations for all our targets, adding unnecessary boilerplate
* Passing 'arguments' to commands requires careful string manipulation/filtering
* Inconsistent behavior across platforms (GNU Make vs BSD Make vs Windows implementations)
* Complex syntax with features we don't need (implicit rules, pattern matching, etc.)
* Error messages can be cryptic and lack context
* Must be invoked from the project root directory
* Doesn't provide cross-platform support out of the box (e.g., Windows support is poor)

**Other:**

* Most of our team is already familiar with Make syntax
* Maintaining the status quo has zero learning curve

### Option 2 Assessment: Migrate to Just

**Pro:**

* Purpose-built for command running, aligning with our actual use case
* No `.PHONY` declarations needed, reducing boilerplate
* Simple parameters/arguments management for commands
* Excellent cross-platform support including Windows
* Clear, intuitive syntax that's easier to learn and maintain
* Better error messages with source context for easier debugging
* Can be invoked from any project subdirectory
* Static error checking catches unknown recipes and circular dependencies before execution
* Strong backward compatibility guarantee
* Modern tooling with active development and community support
* Very similar syntax to Make, making migration straightforward

**Con:**

* Requires installing an additional tool (not available by default on most systems)
* Requires a one-time migration effort to convert the `Makefile` to a `justfile`
* Less universally known than Make (though this is improving)
* Team members need to learn a new tool (though the learning curve is minimal given similarity to Make)

**Other:**

* The project is relatively simple with a small number of commands, making migration easy
* Installation is straightforward with a single curl command
* Can maintain backward compatibility during transition period if needed

### Option 3 Assessment: npm/package.json Scripts

**Pro:**

* npm is already a project dependency for markdownlint-cli2
* Simple syntax for basic commands
* No additional installation required
* Familiar to JavaScript/Node.js developers

**Con:**

* Ties command running to the Node.js ecosystem unnecessarily
* Limited flexibility for complex command sequences
* Doesn't scale well for multi-line commands or complex dependencies
* Less suitable for a primarily Python-based documentation project
* No support for command-line arguments without additional scripting
* Mixing concerns (our primary dependency is Python/uv, not Node.js)

**Other:**

* Would feel inconsistent with the project's primary technology stack (Python, uv, Zensical)

### Option 4 Assessment: Shell Scripts

**Pro:**

* No additional dependencies required
* Maximum flexibility in script implementation
* Familiar to most developers
* Can use platform-specific optimizations

**Con:**

* Requires managing multiple files instead of a single central location
* No built-in help or list functionality for discovering available commands
* Platform-specific scripting (bash for Unix, PowerShell for Windows)
* No centralized error handling or conventions
* More difficult to maintain consistency across scripts
* Harder for new contributors to discover what commands are available

**Other:**

* Would require creating a wrapper script to provide help/list functionality
* File permissions management becomes necessary (chmod +x)

## Recommendation

We recommend **Option 2: Migrate to Just** as our command runner.

Just is purpose-built for exactly our use case - running project-specific commands. While Make is a powerful build system, we're using it solely for command execution, which is outside its primary design purpose. Just provides a cleaner, more maintainable solution with better cross-platform support and improved developer experience.

The migration effort is minimal given our small number of commands, and the syntax similarity to Make means the learning curve for the team is very low. The improved error messages, cross-platform support, and elimination of `.PHONY` boilerplate provide immediate value.

By choosing Just, we're adopting a tool that:

* Aligns with our actual use case (command running vs. build automation)
* Improves the contributor experience across all platforms
* Simplifies our command definitions by removing unnecessary boilerplate
* Provides better tooling for debugging and error handling
* Is actively maintained with a strong commitment to backward compatibility

### Consequences

**Pro:**

* Cleaner, more maintainable command definitions without `.PHONY` declarations
* Better cross-platform support enables Windows-based contributors to work more easily
* Improved error messages reduce time spent debugging command issues
* Can invoke commands from any subdirectory, improving workflow flexibility
* Static error checking prevents runtime errors from undefined recipes
* More intuitive syntax for new contributors to understand and extend

**Con:**

* Contributors must install Just before using the command runner
* One-time migration effort required to convert `Makefile` to `justfile`
* Team members need to learn Just commands (minimal effort given similarity to Make)
* One additional tool in our development toolchain
* GitHub Actions workflows need updating to install and use Just

**Other:**

* Documentation must be updated to reflect the new command runner
* The `Makefile` can be temporarily maintained alongside the `justfile` during transition if needed
* Installation instructions should be added to onboarding documentation

### Confirmation

**Implementation verification:**

* Code review of the `justfile` to ensure all commands are correctly migrated
* Manual testing of each just recipe to verify functionality
* Verification that GitHub Actions workflows successfully use just commands
* Testing on multiple platforms (Linux, macOS, Windows if applicable) to ensure cross-platform compatibility

**Ongoing compliance:**

* Update contributor documentation to reference just commands
* Update GitHub Actions workflows to use just consistently
* Include just installation in development environment setup documentation
* Remove the `Makefile` once the migration is complete and verified
* Document just usage in the `README.md` and onboarding materials

**Success metrics:**

* All commands successfully execute via just
* GitHub Actions workflows pass with just integration
* Reduced setup issues reported by contributors across different platforms
* Positive feedback from team on improved command runner experience

**Responsibility:**

* Architecture team is responsible for maintaining the `justfile`
* Any issues with command execution should be reported via GitHub issues
* Pull requests that add new commands should include `justfile` updates

## More Information

* [Just GitHub Repository](https://github.com/casey/just)
* [Just Documentation](https://just.systems/)
* [Make vs Just Comparison](https://github.com/casey/just#what-are-the-idiosyncrasies-of-make-that-just-avoids)

This decision was made as part of the ongoing effort to improve developer experience and streamline the contribution process for the architecture documentation repository. The migration is being implemented in November 2025 and will be complete once the `justfile` is verified and the `Makefile` is removed.

Future re-evaluation of this decision might be triggered by:

* Significant changes in Just's development or maintenance status
* Emergence of better alternatives for command running
* Changes in team size or composition that significantly impact tooling preferences
* Platform support requirements that Just cannot meet
