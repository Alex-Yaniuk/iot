---
title: Deployment {{ env.ENVIRONMENT }} - {{ env.SERVICE_NAME }} - {{ payload.sender.login }}
labels: {{ payload.sender.login }} , deployment, {{ env.ENVIRONMENT }}, {{ env.SERVICE_NAME }}
---

## Details

- Deployment requested from **{{ payload.sender.login }}**.

---

**NOTE:** 
- The issue will be automatically closed after deployment regardless of status
