brew install promtail
promtail --config.file=./promtail/config/promtail-config.yaml --client.external-labels="hostname=$(HOSTNAME)"