#! /bin/bash

directory_path="$1"
file_extension="$2"
output_file="$3"

usage() {
  echo "Usage: $0 arg1 arg2 arg3 ;  where:"
  echo "    arg1: path to directory being checked"
  echo "    arg2: file extension"
  echo "    arg3: output file to store results in"
} 
 
file_count=$(find $directory_path -type f -name "*$file_extension" | wc -l)

echo "Number of $file_extension files: $file_count" > $output_file