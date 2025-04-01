# GOV.UK Prototype Kit

[GOV.UK Prototype Kit](https://prototype-kit.service.gov.uk/)

Self-promotion: Quickly make interactive, accessible and realistic prototypes of GOV.UK services. Use prototypes to get valuable feedback and insights from user research or the people you work with. The kit is used by teams across government. Anyone can use the kit, including: content/interaction/service designers, developers
user researchers, product owners.

## Evaluation by Joel

Summary: Do not use. My opinion is the kit looks fine on the surface, but the
implementation is poorly maintained, and the git participants have many stranded
issues and pull requests.

### Demo

Joel tried the tutorial project, and turned up many deprecation warnings,
especially in two categories: deprecation warnings due to Dart SaaS, and color
warnings due to the GOV.UK itself.

https://github.com/joelparkerhenderson/demo-gov-uk-prototype-kit

### GitHub repo

https://github.com/alphagov/govuk-prototype-kit/

207 open issues. A recent typical example is "Cannot use
govuk-suppressed-warnings as they are overwritten by the kit" which looks
plausible yet has no response at 3 weeks.

28 pull requests. A recent typical example is "Fixing the default homepage"
which looks plausible but has no review at 6 weeks.

### Support guidance from maintainers

https://github.com/alphagov/govuk-prototype-kit/issues/2389

The GOV.UK Prototype Kit is currently maintained by the GOV.UK Design System
team. Huge thanks to the GOV.UK Prototype team, who’s hard work has made our job
of maintaining the Prototype Kit much easier.

We will:

* update dependencies and address serious bugs

* review bugs and dependencies every 3 months (serious bugs will be given high priority)

We cannot:

* provide user support on Slack, GitHub or via email

* add new features

* review contributions

* update documentation

* address smaller functionality issues that do not block usage

Many departments told us about documentation and support for the Prototype Kit
which was provided internally, so we encourage users to seek help from their
colleagues.
