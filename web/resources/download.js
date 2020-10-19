function downloadURI(uri, name) {
  var link = document.createElement("a");
  link.download = name;
  link.href = uri;
  link.click();
}
function downloadLatest() {
  downloadURI("../builds/LOTRDRP-1.9.jar", "LOTRDRP-1.9.jar");
  downloadURI("../builds/discord-core.jar","discord-core.jar");
}
