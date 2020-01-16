function downloadURI(uri, name) 
{
    var link = document.createElement("a");
    link.download = name;
    link.href = uri;
    link.click();
}
function downloadLatest(){
    downloadURI("../builds/LOTRDRP-1.7.jar","LOTRDRP-1.7.jar")
    downloadURI("../builds/discord-rpc-1.3.1-all.jar","discord-rpc-1.3.1-all.jar")

}