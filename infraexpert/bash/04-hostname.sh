#! /bin/bash

output_file=$1

if [[ $# -ne 1 ]]; then
  echo "Usage: $0 output_file"
  exit 1
fi

echo "Hostname: $(hostname)" | tee $output_file