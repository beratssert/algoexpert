// O(1) time | O(1) space
function validIPAddresses(string) {
  const ipAddresses = [];
  for (let i = 1; i < Math.min(string.length, 4); i++) {
    const ipParts = ["", "", "", ""];

    ipParts[0] = string.slice(0, i);
    if (!isValidPart(ipParts[0])) continue;

    for (let j = i + 1; j < i + Math.min(string.length - i, 4); j++) {
      ipParts[1] = string.slice(i, j);
      if (!isValidPart(ipParts[1])) continue;

      for (let k = j + 1; k < j + Math.min(string.length - j, 4); k++) {
        ipParts[2] = string.slice(j, k);
        ipParts[3] = string.slice(k);

        if (isValidPart(ipParts[2]) && isValidPart(ipParts[3]))
          ipAddresses.push(ipParts.join("."));
      }
    }
  }

  return ipAddresses;
}

function isValidPart(string) {
  const strAsInt = parseInt(string);
  if (strAsInt < 0 || strAsInt > 255) return false;
  return string.length === strAsInt.toString().length;
}

console.log(validIPAddresses("1921680"));
