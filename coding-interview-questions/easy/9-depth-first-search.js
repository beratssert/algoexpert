// O(v+e) time | O(v) space - vertex and edges
function depthFirstSearch(array) {
  array.push(this.name);
  for (let child of this.children) {
    child.depthFirstSearch(array);
  }

  return array;
}
