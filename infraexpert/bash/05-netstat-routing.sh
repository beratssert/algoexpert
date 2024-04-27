#! /bin/bash

set -eo pipefail

if ! output=$(netstat -r); then
  echo "Error: Failed to execute 'netstat' command."
  exit 1
fi

echo "$output"
exit 0