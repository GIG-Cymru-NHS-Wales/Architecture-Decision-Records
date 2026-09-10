# Use a Linter for Markdown Documents

!!! info

    **Status**: Accepted

    **Level**: 1

    **Updated**: 2025-10-20

## Summary

This ADR addresses the need for a standardized approach to maintaining the quality and consistency of markdown documents within the project. It proposes the adoption of a linting tool to automatically check for common mistakes, enforce style guidelines, and improve overall readability. The decision focuses on selecting a tool that is readily available, configurable, and integrates well with the development environment.

## Drivers

The primary drivers for this decision are:

* **Improving Quality**: To enhance the quality of documentation by automatically catching common errors and inconsistencies.
* **Immediate Need**: The need to implement a solution quickly to address current documentation practices.
* **Local Execution**: The requirement for a tool that can be run locally without sending data to external services.
* **VS Code Integration**: To ensure compatibility with the primary editor used by the team.
* **Good Marketplace Rating**: To select a tool that is well-regarded and trusted by the community.
* **Focus on Markdown**: The immediate priority is to improve the quality of markdown documents.
* **Shareable Configuration**: The ability to store the linter's configuration within the project repository for consistency across the team.

## Options

### markdownlint

[markdownlint](https://github.com/DavidAnson/markdownlint-cli2) is a popular, fast, and configurable linter that focuses specifically on markdown. Its configuration can be stored in a `.markdownlint.json` file, making it easy to share across a team.

### trunk.io

[trunk.io](https://marketplace.visualstudio.com/items?itemName=trunk.io) is a more comprehensive tool that supports linting for multiple languages and offers a range of features beyond basic linting.

## Options Analysis

### markdownlint Assessment

**Pro:**

* **Focus on Markdown**: Specifically designed for markdown, which aligns with the immediate need.
* **Popularity**: Widely used and well-regarded.
* **Integrates with VS Code**: See [VS Code marketplace](https://marketplace.visualstudio.com/items?itemName=DavidAnson.vscode-markdownlint).
* **Speed and Configurability**: Fast and allows for a customized ruleset.
* **Shared Configuration**: The configuration can be checked into the repository, ensuring consistency.

**Con:**

* **Limited Scope**: Only supports markdown, which may require additional tools for other languages.

**Other:**

* **Community Support**: Benefits from a large user base and active development.

### trunk.io Assessment

**Pro:**

* **Multi-language Support**: Can handle various file types, offering a single solution for broader linting needs.
* **Extensive Features**: Provides more than just linting, which could be beneficial in the long term.

**Con:**

* **Complexity**: The additional features may introduce unnecessary complexity for the immediate goal.
* **Further Research Needed**: Requires more investigation to fully understand its capabilities and suitability.

**Other:**

* **Potential for Future Use**: Could be a viable option as the project's needs evolve.

## Recommendation

The recommendation is to adopt **markdownlint** for the following reasons:

* It directly addresses the immediate need to improve markdown quality.
* Its simplicity, speed, and configurability make it a practical choice for the current requirements.
* The ability to include the configuration file in the repository ensures that all team members adhere to the same standards.
* Has a VS Code extension to enable built-in linting but can also be run standalone.

The `.markdownlint.json` configuration file will be committed to the top level of the repository. This decision can be revisited if the team's needs change or if a more comprehensive tool becomes necessary.

## Consequences

**Pro:**

* **Improved Consistency**: All markdown documents will follow a consistent style, improving readability and maintainability.
* **Reduced Errors**: Automated checks will catch common mistakes, reducing the manual effort required for reviews.

**Con:**

* **Initial Setup**: Some initial effort will be required to configure the rules and integrate the linter into the workflow.
* **Learning Curve**: Team members will need to familiarize themselves with the chosen linter and its rules.

**Other:**

* **Potential for Automation**: This decision opens the door to integrating automated linting checks into the CI/CD pipeline.

## Confirmation

To confirm the successful implementation of this decision, the following steps will be taken:

* **Configuration File**: The `.markdownlint.json` file will be created and added to the repository.
* **Documentation**: The `README.md` file will be updated with instructions on how to install and run the linter.
* **Local Setup**: The project's `Makefile` will be updated to include a `lint` target for easy local running.
* **PR Process**": A GitHub Action workflow `markdownlint.yml` will be added to run the linter on PRs and fail them if there are errors.
* **AI Support**: The project's `AGENTS.md` file will include the need to lint & fix before raising a PR.

## More Information

For more information on `markdownlint`, please refer to the official documentation and the VS Code marketplace page. Any proposed changes to the linting rules should be discussed with the team and approved before being implemented.
