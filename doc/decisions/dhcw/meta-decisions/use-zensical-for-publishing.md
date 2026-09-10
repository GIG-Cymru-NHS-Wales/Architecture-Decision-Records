# Use Zensical for Publishing

!!! info

    **Status**: Accepted

    **Level**: 1

    **Updated**: 2025-11-14

## Summary

This decision addresses the need to adopt a modern, sustainable static site generator for publishing our architecture documentation. We are migrating from Material for MkDocs to Zensical, a next-generation tool built by the same creators. Zensical represents the natural evolution of Material for MkDocs, offering improved performance, modern architecture, better developer experience, and guaranteed long-term support as the team's primary focus going forward.

## Drivers

* Material for MkDocs, while mature and functional, represents the team's previous generation of documentation tooling
* The creators of Material for MkDocs have developed Zensical as their next-generation platform, indicating where future development effort will be focused
* We need a documentation platform that will be actively maintained and enhanced for years to come
* Modern web performance standards require faster build times and more efficient static site generation
* Developer experience improvements can reduce friction in documentation contribution and maintenance
* We want to align with the trajectory of the original Material for MkDocs team to benefit from their expertise and innovation
* The complexity of managing multiple MkDocs plugins (mkdocs-awesome-nav, table-reader, etc.) adds maintenance overhead

## Options

### Continue with Material for MkDocs

Material for MkDocs is the current solution we use for publishing architecture documentation. It is mature, well-documented, and widely adopted across the industry.

Key characteristics:

* Extensive plugin ecosystem (mkdocs-awesome-nav, table-reader, etc.)
* YAML-based configuration (mkdocs.yml)
* Large community and extensive third-party resources
* Proven track record over many years
* Python-based with broad compatibility

### Migrate to Zensical

Zensical is a modern static site generator built by the same team that created Material for MkDocs. It represents their next-generation approach to documentation tooling.

Key characteristics:

* Built by the creators of Material for MkDocs
* Modern TOML-based configuration
* Improved build performance
* Streamlined feature set with batteries included
* Focus on developer experience and workflow efficiency
* Shares design philosophy with Material for MkDocs (classic variant available)
* Compatible with Material for MkDocs themes and markdown extensions

### Consider Alternative Documentation Platforms

Other options like Docusaurus, VitePress, or Starlight could be considered as alternative modern documentation platforms.

Key characteristics:

* Different technology stacks (JavaScript/TypeScript vs Python)
* Varying levels of maturity and community support
* Different configuration approaches and workflows
* Would require more significant migration effort

## Options Analysis

### Continue with Material for MkDocs Assessment

**Pro:**

* No migration effort required
* Team is already familiar with the tooling
* Existing documentation and processes work without changes
* Large community for support and troubleshooting
* Extensive plugin ecosystem provides flexibility

**Con:**

* Represents previous-generation technology from the team
* Future development focus will be on Zensical, not Material for MkDocs
* Plugin complexity adds maintenance overhead (managing versions, compatibility)
* YAML configuration is less modern than TOML alternatives
* Build performance is adequate but not optimized for modern standards
* May face longer-term sustainability concerns as team focus shifts

**Other:**

* Material for MkDocs will likely continue to receive maintenance but not major innovation
* Migration in the future would become more difficult as our documentation grows

### Migrate to Zensical Assessment

**Pro:**

* Created by the Material for MkDocs team – ensures continuity of expertise and design philosophy
* Future development and innovation will be focused here
* Modern architecture built with lessons learned from Material for MkDocs
* Improved build performance (3-4 second builds vs. longer build times)
* Streamlined configuration with TOML (more modern, type-safe)
* Batteries included approach reduces plugin dependencies
* Compatible with existing Material theme via "classic" variant
* Maintains familiar look and feel for users
* Better developer experience with clearer error messages and faster iteration
* Guaranteed long-term support as the team's primary platform
* Migration path is straightforward for Material for MkDocs users

**Con:**

* Requires one-time migration effort (approximately 1-2 days of work)
* Newer platform with smaller community (though backed by experienced team)
* Requires explicit navigation listing (directory paths don't auto-discover subpages)
* Some MkDocs plugins not directly compatible (though most features built-in)
* Team must learn TOML configuration format (minor learning curve)

**Other:**

* Migration effort is minimized by design compatibility with Material for MkDocs
* Early adoption positions us to benefit from future innovations
* Created specifically to address pain points learned from years of Material for MkDocs development

### Consider Alternative Documentation Platforms Assessment

**Pro:**

* Some alternatives offer modern features and good performance
* Different technology stacks might align with other organizational preferences
* Active communities around major alternatives

**Con:**

* Significantly higher migration effort (complete rewrite of configuration and customizations)
* Loss of familiarity and institutional knowledge
* Different design philosophies may not align with our requirements
* No guarantee of better long-term support than Zensical
* Would lose connection to Material for MkDocs design patterns our team knows
* Risk of choosing a platform that doesn't align with our Python-centric approach

**Other:**

* Moving to non-Python platforms would create inconsistency with our technical stack
* Would lose the benefit of the Material for MkDocs team's continued expertise

## Recommendation

**Adopt Zensical as our static site generator for publishing architecture documentation**, migrating from Material for MkDocs.

### Rationale

Zensical represents the natural evolution of Material for MkDocs by its original creators. By migrating now, we:

1. **Align with the future**: The Material for MkDocs team's focus and innovation efforts will be directed at Zensical, ensuring we benefit from ongoing enhancements and improvements

2. **Gain performance improvements**: Build times of 3-4 seconds provide faster feedback loops during development and more efficient CI/CD pipelines

3. **Reduce complexity**: Built-in features eliminate the need for multiple plugins (mkdocs-awesome-nav, table-reader), simplifying our configuration and reducing dependency management overhead

4. **Maintain continuity**: The "classic" theme variant preserves our existing visual design and user experience, minimizing disruption for documentation consumers

5. **Improve developer experience**: Modern TOML configuration, better error messages, and streamlined workflows make it easier for team members to contribute to documentation

6. **Ensure long-term sustainability**: As the team's primary platform going forward, Zensical will receive active development, new features, and sustained support for years to come

7. **Minimize migration risk**: High compatibility with Material for MkDocs design patterns and markdown extensions means migration is straightforward and low-risk

The migration effort is justified by the long-term benefits of aligning with the platform's future trajectory. Delaying migration would only increase future effort as our documentation grows.

### Consequences

**Pro:**

* Future-proof platform choice backed by the team that created Material for MkDocs
* Improved build performance speeds up development workflows
* Simplified configuration and reduced plugin dependencies ease maintenance
* Modern architecture positions us to benefit from future innovations
* Better developer experience encourages documentation contributions
* Continued support and development guaranteed as the team's primary focus

**Con:**

* One-time migration effort required (configuration, navigation structure, CI/CD)
* Team must learn TOML configuration format (minor learning curve)
* Explicit navigation listing requires more initial setup (but provides better control)
* Smaller community compared to mature Material for MkDocs (though backed by same expert team)
* Some advanced MkDocs plugins not directly compatible (though core features built-in)

**Other:**

* Documentation look and feel remains consistent for end users (classic variant)
* Migration provides opportunity to review and improve documentation structure
* Early adoption gives us voice in shaping the platform's evolution

### Confirmation

**Implementation verification:**

* Site builds successfully with `zensical build` command
* All pages render correctly with preserved formatting
* Navigation structure maintains logical organization
* Search functionality works across all content
* Custom CSS, logos, and branding elements display properly
* Analytics integration continues to function
* GitHub Actions deployment pipeline works correctly

**Ongoing compliance:**

* Documentation builds are automated via GitHub Actions
* Build failures prevent deployment, ensuring quality
* Regular reviews of Zensical release notes to adopt new features
* Team training and onboarding materials updated to reference Zensical

**Success metrics:**

* Build time < 5 seconds (vs. previous longer builds)
* Zero errors or warnings in build output
* Maintained or improved documentation contribution frequency
* Positive team feedback on developer experience
* Successful deployment to GitHub Pages on each merge

## More Information

**Related decisions:**

* This decision supersedes [Use Material for MkDocs for Publishing](use-material-for-mkdocs-for-publishing.md) which is now deprecated
* See [Format Architecture Decision Records with Markdown](format-architecture-decision-records-with-markdown.md) for markdown formatting approach
* See [Site Navigation](enable-mkdocs-enhanced-site-navigation.md) for navigation structure decisions

**References:**

* [Zensical Official Website](https://zensical.org/)
* [Zensical Documentation](https://zensical.org/docs/get-started/)
* [Zensical GitHub Repository](https://github.com/zensical/zensical)
* [Material for MkDocs](https://squidfunk.github.io/mkdocs-material/) (predecessor)

**Decision context:**

* Decision made: November 2025
* Implemented by: Architecture team
* Migration completed: November 2025
* Approved by: DHCW Technical Design Authority (TDA)

**Future review:**

* This decision should be reviewed if:
    * Zensical development ceases or changes direction significantly
    * A major new documentation platform emerges that offers compelling advantages
    * Team requirements change substantially (e.g., move away from Python ecosystem)
    * Build performance or maintainability degrades significantly
