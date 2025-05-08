# Containerization

!!! note
    Work in Progress

**Status**: first sketch, work in progress, request for collaboration

**Date**: 2025-04-17

**Governance**: To Be Discovered; potentially a combo of this repo participants, DHCW CISO, NHS Wales UCB peers, etc.

## Situation - Context and Problem Statement

To support our software engineering teams with reliable, portable, and secure
environments for application development, testing, and deployment, we need a
consistent approach to containerization, container management, and container
deployment.

Right now we need:

* Capabilities for software engineers to develop software locally in a container.

* Capabilities for software engineers to download and run software in containers.

Broadly we want to aim for:

* Support for **infrastructure-as-code** and CI/CD pipelines.

* Demand for **rootless** and secure containers (developer-friendly, production-safe).

* Consideration for **direct vs. orchestrated** container management.

* Growing interest in **serverless runtimes** and integration with ephemeral compute.

We must decide on:

* Container engine(s) to use (such as Docker, Podman, etc.)

* How we build, run, and manage containers (locally, in CI/CD/CT, in demos, in production, etc).

* Deployment methods (manual, automated, orchestrated, serverless, etc).

## Drivers

* **Compatibility:** Must work well with Git/GitHub, Tofu/Terraform, CI/CD/CT pipelines.

* **Portability:** Support across developer machines and CI environments.

* **Flexibility:** Support serverless where appropriate.

* **Security:** Rootless containers reduce the attack surface.

* **Simplicity:** Avoid Kubernetes unless orchestration is absolutely required.

## Considered options and related tooling

* Container implementations: Docker, Podman, any others?

* Serverless e.g. closed-source platform-specific such as AWS Fargate Serverless Compute, open-source platform-agnostic such as Knative, any others?

* Direct management (e.g., via systemd or scripts)

* Orchestration tools: Kubernetes, any others?

### Summaries by ChatGPT

**Docker** is an open-source platform that enables developers to build, package,
and run applications in lightweight, portable containers. A container bundles an
application with all its dependencies, libraries, and configuration files,
ensuring it runs consistently across different environments—from a developer’s
laptop to production servers. Docker simplifies software delivery by isolating
applications from the underlying infrastructure, reducing conflicts and
streamlining DevOps workflows. It includes tools for building container images,
managing containers, and orchestrating multi-container applications, and it
serves as a foundational technology for modern, microservices-based and
cloud-native architectures.

**Podman** is an open-source container management tool that allows users to
build, run, and manage containers and pods without requiring a daemon, unlike
Docker. Developed by Red Hat, Podman is designed with security and rootless
operation in mind, enabling users to run containers as non-root users for better
system isolation and compliance. It supports the same container image formats as
Docker and offers a compatible command-line interface (`podman` can often
replace `docker` commands). Podman also supports Kubernetes YAML generation and
can manage pods natively, making it a strong choice for secure and
standards-compliant container workflows.

**Kubernetes** is an open-source container orchestration platform that automates
the deployment, scaling, management, and networking of containerized
applications. Originally developed by Google and now maintained by the Cloud
Native Computing Foundation (CNCF), Kubernetes allows users to define the
desired state of their applications and ensures that the system continuously
works to maintain that state. It manages clusters of nodes (servers) and
coordinates containers to run efficiently across them, handling load balancing,
service discovery, rolling updates, and self-healing in case of failures.
Kubernetes is a foundational technology for cloud-native infrastructure,
enabling resilient, scalable, and portable application deployments across
diverse environments.

**kubectl** is the command-line tool used to interact with Kubernetes clusters,
allowing users to deploy applications, inspect and manage cluster resources, and
view logs or events. It communicates with the Kubernetes API server to execute
commands such as creating pods, scaling deployments, updating configurations,
and troubleshooting workloads. The kubectl command is essential for developers
and administrators working with Kubernetes, providing a powerful and flexible
interface for managing the full lifecycle of containerized applications.

**Buildah** is an open-source command-line tool designed to create and manage
container images without requiring a Docker daemon. It enables developers to
build container images in a flexible and lightweight manner, either by using a
Dockerfile or through direct commands to add files and configure image layers.
Buildah is particularly useful in environments where running a full Docker
daemon is unnecessary, such as in CI/CD pipelines or Kubernetes setups. It
integrates well with other container tools like Podman and can push images to
container registries, offering a more efficient and customizable alternative for
building and managing container images.

**Conmon**** (short for "container monitor") is an open-source tool designed to
monitor and manage container processes in a lightweight and efficient manner. It
is typically used in conjunction with container runtimes like Podman and
Kubernetes to handle the monitoring of container lifecycles, including logging,
handling the standard input/output streams, and managing the container’s exit
status. Conmon runs as a subprocess alongside the container, ensuring that the
container’s logs and process status are properly captured and reported. It
provides a minimal, low-overhead solution for container monitoring, focusing on
keeping the container's environment clean and efficient without introducing
unnecessary complexity.

**Trivy** is an open-source vulnerability and security scanner developed by Aqua
Security, designed to detect issues in container images, file systems, and
source code repositories. It scans for a wide range of security problems,
including OS package vulnerabilities (e.g., in Alpine, Debian, Ubuntu),
language-specific package issues (e.g., pip, npm, bundler), misconfigurations in
Kubernetes and Docker, exposed secrets, and software licenses. Trivy is
lightweight, easy to use, and integrates well into CI/CD pipelines, making it a
popular tool for DevSecOps workflows to ensure containers and infrastructure are
secure before deployment.

**Copacetic** is an open-source command-line tool developed by Microsoft and
hosted under the CNCF Sandbox. It enables DevSecOps teams to patch container
image vulnerabilities directly, without the need to rebuild the entire image. By
integrating with popular vulnerability scanners like Trivy, Copacetic identifies
outdated or vulnerable packages and applies updates as additional layers on top
of the existing image. This tool is particularly beneficial for patching
inherited base image vulnerabilities or third-party application images without
waiting for upstream updates.

**Harbor** is an open-source cloud-native registry project that stores, signs,
and scans container images for vulnerabilities, with a focus on security,
compliance, and performance in enterprise environments. Developed by VMware and
now part of the CNCF (Cloud Native Computing Foundation), Harbor extends Docker
Registry with features like role-based access control, image replication across
registries, and integration with vulnerability scanners such as Trivy for
continuous scanning. It automates security checks on container images as they're
pushed or pulled, enabling organizations to enforce policies and maintain a
secure software supply chain throughout the development lifecycle.

**Kind** (Kubernetes in Docker) is an open-source tool for running local
Kubernetes clusters using Docker container "nodes." Designed primarily for
testing and development, Kind allows users to spin up lightweight Kubernetes
clusters without needing virtual machines or external cloud infrastructure. It
runs each Kubernetes node inside a Docker container, making it ideal for CI/CD
pipelines, prototyping, and learning Kubernetes in a controlled,
resource-efficient environment. Kind supports multi-node clusters and integrates
well with standard Kubernetes tooling like `kubectl`.

**Crossplane** is an open-source, multi-cloud control plane that enables the
management of cloud infrastructure and services using Kubernetes-style
declarative APIs. It extends Kubernetes to allow users to provision and manage
resources across multiple cloud providers (like AWS, Azure, Google Cloud) and
on-prem environments from a single control plane. Crossplane enables
infrastructure as code (IaC) by defining resources using Kubernetes manifests,
allowing developers to manage everything from databases to networking resources
and virtual machines. This unified approach simplifies complex infrastructure
management, promotes consistency across cloud environments, and supports a more
flexible, scalable architecture for modern cloud-native applications.

**Rancher** is an open-source container management platform that simplifies
deploying, managing, and scaling Kubernetes clusters across on-premises, cloud,
and hybrid environments. Developed by SUSE, Rancher provides a centralized user
interface and API for administering multiple Kubernetes clusters, regardless of
where they're running. It offers tools for lifecycle management, access control,
monitoring, security policy enforcement, and integrated application catalogs.
Rancher streamlines DevOps workflows by abstracting much of the complexity of
Kubernetes, making it easier for teams to operate and govern containerized
applications at scale.

**Helm** is an open-source package manager for Kubernetes that helps developers
and operators define, install, and manage complex Kubernetes applications using
reusable, version-controlled templates called *charts*. A Helm chart bundles all
the necessary Kubernetes manifests—like deployments, services, and config
maps—into a single package, making it easy to deploy applications consistently
across environments. Helm simplifies application lifecycle management by
enabling upgrades, rollbacks, and configuration overrides through values files.
As a CNCF project, Helm is widely used to streamline Kubernetes operations,
reduce manual configuration, and promote best practices in infrastructure as
code.

**Knative** is an open-source platform built on Kubernetes that enables the
development, deployment, and management of serverless applications. It provides
a set of components that abstract away the complexity of managing serverless
workloads, allowing developers to focus on writing code without worrying about
the underlying infrastructure. Knative includes features like automatic scaling
(including scaling to zero), event-driven architecture, and support for both
stateless and stateful workloads. It integrates seamlessly with Kubernetes and
tools like Istio, offering capabilities for routing, traffic splitting, and
service management. Knative is ideal for building modern, cloud-native
applications that need to scale dynamically based on demand while leveraging
Kubernetes for orchestration.

**Amazon Web Services (AWS) Fargate** is a serverless compute engine for
containers that allows users to run containerized applications without having to
manage the underlying server infrastructure. Integrated with Amazon ECS (Elastic
Container Service) and Amazon EKS (Elastic Kubernetes Service), Fargate
automatically provisions, scales, and manages compute resources needed to run
containers, so developers can focus on building and deploying applications. With
Fargate, there’s no need to choose instance types or manage cluster
capacity—users simply define their container requirements, and AWS handles the
rest, offering a pay-as-you-go model that improves scalability, security, and
operational efficiency.

**Amazon Web Services (AWS) Elastic Container Service (ECS)** is a fully managed
container orchestration service provided by AWS, designed to simplify the
deployment, management, and scaling of containerized applications. It allows
users to run and manage Docker containers across a cluster of virtual machines,
using tasks and services to automate container deployment, scaling, and
networking. ECS integrates seamlessly with other AWS services like Elastic Load
Balancing, IAM, and CloudWatch, providing a secure and scalable platform for
containerized applications. ECS offers two launch types: EC2 (for running
containers on EC2 instances) and Fargate (for serverless container management),
giving users flexibility in how they manage their container infrastructure.

**Amazon Web Services (AWS) Elastic Kubernetes Service (Amazon EKS)** is a
managed service provided by AWS that simplifies the deployment, management, and
scaling of containerized applications using Kubernetes. EKS automatically
handles tasks like cluster provisioning, patching, and scaling, allowing
developers to focus on building and deploying applications rather than managing
infrastructure. It integrates seamlessly with other AWS services such as Elastic
Load Balancing, IAM, and Amazon VPC, providing security, networking, and
monitoring capabilities. EKS supports both AWS infrastructure and on-premises
environments, making it ideal for running scalable, resilient containerized
applications in a secure and managed Kubernetes environment.

**Google Kubernetes Engine (GKE)** is a fully managed Kubernetes service
provided by Google Cloud, designed to simplify the deployment, management, and
scaling of containerized applications using Kubernetes. GKE handles the
complexities of Kubernetes, such as managing the control plane, upgrades, and
scaling, while giving users full control over the worker nodes and container
workloads. It offers integrated features like auto-scaling, monitoring,
security, and load balancing, as well as deep integration with other Google
Cloud services, enabling seamless DevOps workflows and efficient cloud-native
application management. GKE provides a highly available and reliable platform
for running applications at scale, making it one of the most popular managed
Kubernetes services in the cloud.

**Microsoft Azure Kubernetes Service (AKS)** is a managed Kubernetes service
provided by Microsoft Azure that simplifies the deployment, management, and
scaling of containerized applications using Kubernetes. With AKS, Microsoft
handles the Kubernetes control plane, including updates, patching, and scaling,
allowing developers to focus on building and running their applications rather
than managing infrastructure. AKS integrates with Azure’s ecosystem, providing
built-in monitoring, security features, and seamless integration with other
Azure services like Azure Active Directory, networking, and storage. It supports
automated scaling, load balancing, and rolling updates, making it easier to
deploy, maintain, and scale applications in a cloud-native environment.

**ArgoCD** is an open-source continuous delivery (CD) tool for Kubernetes that
automates the deployment of applications using GitOps principles. It enables
declarative management of Kubernetes resources by linking them to Git
repositories, where application configurations and manifests are stored. ArgoCD
continuously monitors these repositories for changes and automatically applies
them to the Kubernetes clusters, ensuring the deployed state matches the desired
configuration in Git. It provides a user-friendly web interface and CLI for
managing applications, visualizing deployment status, and rolling back changes
when necessary. By integrating with Git as the source of truth, ArgoCD ensures a
secure, auditable, and automated workflow for Kubernetes application delivery.

**Portainer** is an open-source, lightweight container management platform that
simplifies the deployment, management, and monitoring of Docker and Kubernetes
environments. It provides a user-friendly web interface for managing
containerized applications, allowing users to easily create, configure, and
monitor containers, images, networks, and volumes. Portainer supports both
Docker and Kubernetes clusters, offering a unified management interface for
users who may work with different container orchestration systems. It also
provides role-based access control (RBAC) and a variety of features to
streamline DevOps workflows, making it a popular choice for both beginners and
experienced developers looking to manage containers in a simplified, accessible
way.

## Evaluation

### Docker

Pros:

* Ubiquity

* Wide ecosystem

* Docker Compose is very handy.

Cons:

* Requires daemon

* Default setup needs root access unless configured

* Licensing shenanigans

### Podman

Pros:

* Rootless

* Daemonless

* OCI-compatible

* Docker CLI compatible

Cons:

* Some ecosystem gaps

* Fewer tutorials and LLM prompts

### Serverless (Lambda, Knative)

Pros:

* Auto-scaling

* No infra to manage.

Cons:

* Cold start latency

* Limited runtime control

* Vendor-specific setup doesn't lend itself to multi-cloud resilience

* No overlap with local tooling

### Direct management (e.g., via systemd or scripts)

Pros:

* Lightweight, fast, easy

* Excellent for local software engineering

Cons:

* Lacks orchestration

* Not scalable

* Not easy in the cloud

### Kubernetes / Orchestration tools

Pros:

* By far the most powerful, scalable, and capable, for professional operations teams

* Definitely where we want to be aiming in the next couple of years

Cons:

* Complex - probably too complex to ask mid-level software engineers to pick up for a non-ops project

* Overhead - probably too big a lift right now for us, because we don't have the networking setups

## Implications

* Software engineering developer environments should transition to containers where feasible.

* CI/CD/CT pipelines will include container build steps with containers, depending on runner environment.

* Documentation and training needs to be created for software engineers to learn about containerization.

* For more-complex deployment needs, we'll need to create a path for
  containerization leading to eventual use of Kubernetes or serverless platforms
  depending on cost/performance trade-offs.

## References

* [Podman Documentation](https://podman.io)

* [Docker Documentation](https://docs.docker.com)

* [Open Container Initiative (OCI)](https://opencontainers.org/)

* [AWS Lambda Container Support](https://docs.aws.amazon.com/lambda/latest/dg/images-create.html)

## Decision

We will adopt the following containerization and management strategy:

Container Engine:

* Use **Podman** as the default engine for local development and rootless use cases.

* Support **Docker** where Podman isn't viable, such as a project already using Docker Compose.

Container Image Management:

* Use **OCI-compliant** image builds.

* Store and retrieve images via internal and external registries (e.g., ECR, Docker Hub, GitHub Container Registry).

Execution and Management:

* For local development: encourage **Podman rootless** containers to increase security and reduce dependency on Docker daemon.

* For CI/CD/CT: Use **containerized runners** (e.g., GitHub Actions, GitLab Runners) with Podman setups depending on environment support.

* For ephemeral execution: leverage serverless runtimes when the workload fits.

Infrastructure as Code Integration:

* Container lifecycle (build, deploy, destroy) will be managed through IaC tools such as Tofu/Terraform, or similar complementary technologies such as Dagger, Pulumi or Ansible. We intend to do a complementary ADR for these.

* All container-related infra should be declarative and version-controlled.
