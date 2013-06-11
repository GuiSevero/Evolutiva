/*

http://dev.w3.org/2006/webapi/FileAPI/
http://www.html5rocks.com/pt/tutorials/file/filesystem/
http://www.html5rocks.com/en/tutorials/file/dndfiles/

*/

function FileHelper(){

	this._file = new Array();

	this.loadFile = function(container){

		this._file  =  document.getElementById(container).files[0];

		return this._file;
	}

	this.getAsText = function (readFile, callback) {
    
	  var reader = new FileReader();
	  
	  // Read file into memory as UTF-16      
	  reader.readAsText(readFile);
	  
	  // Handle progress, success, and errors
	  reader.onprogress = this.updateProgress;
	  reader.onerror = this.errorHandler;
	  reader.onload = this.loaded;
	  reader.userCallback = callback;
	}



	this.updateProgress = function (evt) {
	  if (evt.lengthComputable) {
	    // evt.loaded and evt.total are ProgressEvent properties
	    var loaded = (evt.loaded / evt.total);
	     console.log(loaded);
	    if (loaded < 1) {
	      console.log((loaded * 100) + ' % of file loaded');
	    }
	  }else{
	  		console.log('Not Computable');
	  }
	}

	this.loaded = function (evt) {  
	  // Obtain the read file data    
	  var fileString = evt.target.result;
	  
	  return this.userCallback(fileString);     
	}

	this.errorHandler = function (evt) {
	  if(evt.target.error.name == "NotReadableError") {
	    // The file could not be read
	  }
	}



}


