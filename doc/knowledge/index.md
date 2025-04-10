# Knowledge

!!! note
    Work in Progress

**Status**: first sketch, work in progress, request for collaboration

**Date**: 2025-03-21

**Governance**: To Be Discovered; potentially a combo of this repo participants, DHCW CISO, NHS Wales UCB peers, etc.

## Context

Broadly, our organization aims to improve our knowledge building and knowledge sharing. For example, we have major multi-year work fronts to create our medical software with domain knowledge, to improve software engineering with programming knowledge, to widen our data research needs with statistical knowledge, and to innovate our AI adoption with machine learning knowledge. Knowledge work can be improved by better ways of working and by software for knowledge management systems (KMS).

Specifically, right now for the emergency department module, Joel is discovering that knowledge within the organization tends to be tribal and trapped in internal systems. In the past week, Joel and teammates have had total knowledge misses, meaning our people know the work exists but can't find it or can't share it. This causes delays, confusions, frustrations, and unnecessary redos. Joel and the software engineers need ways to find documentation and share it with each other.

## Drivers

We want to immediately increase our capabilities to create knowledge, find it, share it, and update it. We want to do this immediately for knowledge for the emergency department module and it's related software engineering work.

A couple of pieces where Joel believes better knowledge management is urgent for this specific project:

1. Authentication such as for our use cases, which also will lead into authentication for more of our software engineering projects.

2. Reification, which means we "make real" the various high-level knowledge that we have in hand, so we can ship real code faster, then iterate on the knowledge and the code.

A couple of ways of working that we believe are lightweight and can help right now:

1. Shifting what we can from private-first to public-first. For example, shifting from intranet knowledge to more extranet knowledge. Newer ways of working include us working in the open on ADRs such as this one, as well as our new public GitHub organization, and our relationships with peer organizations including NHS England, GOV.UK, UK NCSC, etc.

2. Shifting what we can from must-be-perfect to could-be-good-enough. For example, shifting documentation from a many-day many-tier many-person approval process of a final finished gorgeous PowerPower to a few-hour few-person approval process of a first draft of a markdown text file.

A couple of knowledge management systems that we believe are lightweight and can help right now:

1. Something TBD for upskilling our team. We have multiple inbound requests from staff about how to learn GitHub to work on ADRs, how to use AI code assistants to speed up boilerplate programming, how to share work-in-progress documentation URLs with our peer organizations, etc.

2. Something TBD for tagging and searching for knowledge. We have need obvious tags such as for software engineering topics (e.g. #authentication, #authorization), software tools (e.g. #git, #copilot), software languages (e.g. #javascript, #python).

Business drivers:

1. The organization needs a way to ensure knowledge is not only captured but also shared effectively among all employees. Knowledge sharing is essential for innovation, problem-solving, and continuous learning across departments.

## Options

Knowledge is a massive topic, so we want to quickly sketch some options for us to consider.

### Formal synchronous knowledge-sharing

Examples: webinars, workshops, upskilling sessions, training programs.

Resources: typically these work best when there is dedicated time, equipment, rooms, and people.

Example pros: High-quality, structured content; clear focus on knowledge dissemination.

Example cons: Time-consuming; could be difficult to maintain long-term.

### Informal asynchronous knowledge-sharing

Examples: collaboration tools and communication platforms, such as wikis, blogs, chats, virtual whiteboards, kanban boards, etc.

Resources: typically these work best when there is organizational IT capability for setup, ongoing tuning, and scaling.

Example pros: Easier to scale; integrates well with daily work; encourages spontaneous knowledge sharing.

Example cons: Lack of structure may lead to fragmented knowledge sharing; less formalized tracking.

### Hybrid formal/informal knowledge-sharing

Examples: a quarterly presentation about a topic that aligns with an ongoing chat channel where people can ask questions, share links, etc.

Resources: as above.

Example pros: Combines the best of both worlds; structured programs for high-priority topics, while also allowing organic knowledge sharing.

Example cons: More complex to implement; people might miss out on knowledge in one of the presentations or one of the channels, without realizing it.

### System quality attributes to consider

**Usability**: Team members need to be able to easily contribute, edit, and interact with the knowledge base.

**Flexibility**: The solution must accommodate both structured and informal ways of sharing knowledge.

**Searchability**: The ability to search through documents and retrieve relevant information quickly is essential.

**Scalability**: The system must be able to handle increasing amounts of data as the organization grows.

**Security**: Sensitive information must be stored securely, with access control in place.

**Integratability**: The system should integrate well with other internal tools (e.g., document management systems, chat apps, etc.).

## Consequences

Examples that we want to know more about...

**Positive**:

* Employees will have multiple avenues to share knowledge, which increases engagement.

* Combining formal and informal approaches allows for scalability while maintaining quality.

* By using communication platforms like Slack, employees can seamlessly share knowledge in real-time, fostering continuous learning.

**Negative**:

* Maintaining engagement could become challenging if the initiative is not properly supported by leadership.

* Lack of structure in informal sharing may result in valuable knowledge being lost or overlooked.

## Recommendations

Start right now with lightweight ways of working and lightweight documentation tooling. 

Use these as landing zones:

1. Create our new external GitHub organization, with new public repositories, where we add new documentation, code, tests, etc. Share it among staff, and peer organizations, and the general public.

2. Favor simple open formats and simple open standards for good-enough knowledge discussion, such as favoring text files over PowerPoint, ADRs over SADs, ad-hoc tagging with "#tag" syntax over formal rigid hierarchical ontologies.

3. Leverage free open source software for searching and indexing our external knowledge work. We're starting with mkdocs and iterating to add mkdocs-awesome-nav.
