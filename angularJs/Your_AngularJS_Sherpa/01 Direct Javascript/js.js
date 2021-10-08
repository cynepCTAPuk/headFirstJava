function updateOutput(elem) {
  var name = elem.value;
  var outputElement = document.getElementById("output");
  outputElement.innerHTML = "Hello " + name;
}