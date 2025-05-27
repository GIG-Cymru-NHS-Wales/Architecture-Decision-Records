# Application performance management (APM)

!!! info

    **Status**: WIP RFC

    **Updated**: 2025-05-26

## Summary

We are deploying many applications and we want to rapidly sigificantly improve
our system quality attributes, focusing on patients and clinicians, and with
many needs for across-application uses. The category of tooling for this is
known as application performance management (APM). We are seeking APM tooling
that includes user experience monitoring (UEM), application analytics (AA),
discovery/tracing/diagnostics (DTD), and related areas. Wikipedia:
<https://en.wikipedia.org/wiki/Application_performance_management>

## Drivers

* Now: we are developing the emergency department module (EDM), and we need to
  get clinician feedback on the authentication (which is UEM), and need to
  discover latency (which is AA), and need to discover and trace diagnostics
  across EDM subsections.
  
* Soon: we need to do the same for the upcoming nursing care record (NCR)
  application, plus we are hearing currently reports of performance problems
  includingly slow responsiveness that's impeding work to the point of the users
  wanting a full rewrite; we current don't know if the issues are caused by
  code, or data, or networking.

* Also: We are onboarding for a role "Head of Enpterprise Operations
  Monitoring". We want to enable this person to take point on providing
  sufficient APM capabilities across all our applications.

## Options

* Dynatrace
* Datadog
* Honeycomb
* Sentry
* Sumo Logic
* Splunk
* New Relic
* Grafana / Grafana Cloud
* Groundcover
* Cloud Metrics
* Parseable
* Signoz
* Coralogix
* Dash0 <https://www.dash0.com/>
* last9.io <https://last9.io/>
* KloudMate
* mutis

## Advice

Advice from <https://www.reddit.com/r/devops/comments/1kvlssd/cheaper_datadog_alternative_for_apm/>

Probably the easiest setup for centralized logging is Grafana + Loki if youre on K8S

Are you on a committed contract? Half the time when I hear people talking about
how expensive Datadog is it’s because they’re paying on demand without a
contract, which gets you way better rates. The other half are turning on
features left and right without any idea how it affects their bill. Full
disclosure, I do Datadog implementations as a consultant. Datadog and Dynatrace
are very expensive for a reason. They do all the things with relative ease with
a bunch of fancy integrations. Anything else is going to take a bit of work.

Grafana Cloud + Sentry is a very powerful combo. You'll get a good chunk out of
the box. But if you want the full suite of custom metrics, traces, profiling,
etc. like datadog gives you, then you're going to have to put in some dev work.

We recently switched away from Datadog primarily because it was getting so
expensive. We moved to Grafana + Sentry and we have the hands/bandwidth to make
it work. As a team we all miss the user friendliness of DD but the cost savings
are astronomical.

Our company switched from DataDog to NewRelic due to costs. The APM agents are
pretty good with great code insight and nice distributed tracing between
microservices.

New Relic is fantastic.

Check out <https://opentelemetry.io/> and research if it supports your
application language, where to visualize results, and how to ship data.

Elastic internally could work for logs, but for APM, I'd recommend checking out
Parseable (disclaimer: I’m part of the team).

Parseable is a self-hosted, open-source platform for full-stack observability
(logs, traces, metrics) with a strong focus on cost (runs directly on S3/object
storage, so no data egress penalties or storage surprises). It is
OpenTelemetry-native: just use standard OTel agents. There are no deep code
changes, and you can usually “sidecar” or daemonset your way into most
environments (works for Python, Node.js, and more). The company is working on
(and already support basic) DB telemetry, Postgres, MySQL, etc., so you can tie
your web traces directly to database calls. But not a fully managed SaaS (yet),
so you’d need to host it, though setup is pretty straightforward if you already
run things on K8s or similar. Not as mature as Datadog/Splunk in every checkbox,
but cost-effective at scale.

Use LGTM, Loki, grafana, tempo, mutis. The piece you care for is tempo for
traces. You can also replace mutis with Aws managed Prometheus if you can use
it.

You could try KloudMate. It's OTel native, and comes at a fraction of what the
big D might cost. Covers the full hog correlation of metrics, logs, traces and
much more (such as native modules like Incident Management, etc...)
<https://docs.kloudmate.com/nodejs-application>

Signoz

Coralogix is an observability platform with full APM, networking monitoring, DB
monitoring, browser based RUM and a bunch more. What makes Coralogix different:
it analyses in-stream, and queries from remote. This means RUM, APM, SIEM, AI,
Logs, Metrics, Traces etc. are processed and stored in cloud object storage
(like S3) in your account, where it can be queried without rehydration at no
extra cost. Coralogix cuts 70% of the DataDog bill from customers who migrate.
In terms of integration, we've got support from eBPF through to OpenTelemetry
native integrations. <https://coralogix.com/platform/apm>

Dash0 <https://www.dash0.com/>

last9.io <https://last9.io/>. They have been around for last 6 years and are
being used by some big names. They claim to reduce the overall observability
cost by 67% and also have a feature to import from DataDog.

If you're using python then Sentry.io is fantastic value for money. It does a
whole bunch of what you want. I haven't tried with other languages.

Grafana + OTEL + Tempo on S3 is a decent option for tracing.

We are currently switching from DataDog to Grafana Cloud. Significant savings,
but increased complexity.

We use self-hosted Elastic-stack on Kubernetes (deployed with ECK). Elastic APM
is amazing and as we use the OSS version, the only costs come from the actual
worker nodes. The setup takes some effort to get right, but definitely worth it.

We did a comparison of DataDog, Dynatrace, and open source tools (more or less
LGTM stack). Dynatrace was about 2/3 the price of DataDog, and the open source
stack was needing more engineering time and money to stay useful, so we landed
on Dynatrace. The agent is pretty good for just install it and go. Synthetics
are handy (but can get pricey quick), RUM is neat. It’s a great tool… once you
figure out how the heck to use it. The learning curve is quite steep, and that’s
a big problem with getting many people to use it correctly. They have a lot of
API options for automation and integrations (they could use a few less actually
lol). As a vendor, they’ve been pretty great. We accidentally spun up a bunch of
things that we didn’t realize would cost us a lot of money, they reached out
immediately and worked with us to fix it and figure out how to do what we wanted
for a fraction of the cost.

### {Option 1 Title}

{Describe the option, provide a summary, list the facts, provide links etc.}

### {Option n Title}

...

## Options Analysis

{This is where you critically evaluate each option presented in the *Options*
section. For each option, provide a balanced view of its advantages,
disadvantages, and any other relevant considerations or trade-offs. Be specific
and, where possible, relate your points back to the *Drivers*.

Consider aspects like:

* Cost (development, operational, licensing)
* Complexity (implementation, maintenance, learning curve)
* Risks (technical, operational, security)
* Alignment with architectural principles or existing standards
* Impact on performance, scalability, usability, maintainability,
    security etc.

Include as may Pro/Con/Other statements as required.
}

### {Option 1 Assessment}

* Pro: {A specific advantage or benefit of this option.}

* Con: {A specific disadvantage, risk, or cost associated with this option.}

* Other: {A relevant point that isn't strictly a pro or con.}

### {Option n Assessment}

...

## Recommendation

{This is where you clearly state the final decision, and explicitly name the
option that has been selected. Explain in detail **why** this option was chosen.
You should clearly articulate how the chosen option best addresses the *Drivers*
and meets the key requirements or solves the stated problem.}

### Consequences

{This section is **optional**.}

{Now that a decision has been made what are the expected outcomes and impacts,
both positive and negative? What known limitations, costs, or risks are being
accepted by making this decision? How will this decision affect different
stakeholders, other systems, development practices, operational procedures, or
user experience?}

* Pro: {A specific positive outcome or benefit expected from this decision.}

* Con: {A specific accepted downside, cost, or risk resulting from this
    decision. }

* Other: {A consequence that isn't strictly a pro or con.}

### Confirmation

{This section is **optional**.}

{Outline how the implementation of this decision will be verified and how
ongoing compliance will be ensured. This helps demonstrate that the decision
isn't just theoretical but will be actively put into practice and monitored.

How will you check that the decision has been correctly implemented?
(e.g., code reviews, specific tests, demonstrations, peer review).

How will adherence to this decision be maintained over time? (e.g., automated
checks, periodic audits, updates to team guidelines, training).

Are there specific metrics or indicators that will show the decision is
achieving its intended positive outcomes? (e.g., performance benchmarks,
adoption rates, reduction in specific errors, user feedback scores).

Who is responsible for overseeing this, and what happens if the decision is
not followed?}

## More Information

{This section is **optional**.}

{Use this section to provide any supplementary information that supports the
decision, adds context, or guides future actions. Links to other decisions
and resources might appear here as well.

You could briefly note who was involved in the decision-making process and
if/how consensus was reached. You may also want to suggest a timeframe or
specific events that might prompt a re-evaluation of this decision in the
future.}
