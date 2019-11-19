var url = location.search;
var req = new Object();
if (url.indexOf("?") != -1) {
	var str = url.substr(1), strs = str.split("&");
	for ( var i in strs) {
		req[strs[i].split("=")[0]] = unescape(strs[i].split("=")[1]);
	}
}