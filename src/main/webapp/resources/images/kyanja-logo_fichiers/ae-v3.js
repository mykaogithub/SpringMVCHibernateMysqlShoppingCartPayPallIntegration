"use strict";if(void 0===AeTracker){var t=function(){};t.prototype={generate:function(){var e=[],t=this.fingerprint_useragent(),i=this.fingerprint_language(),r=(this.fingerprint_display(),this.fingerprint_timezone()),a=this.fingerprint_os(),n=this.fingerprint_donottrack(),o=this.fingerprint_cookie(),s=this.fingerprint_canvas(),l=this.fingerprint_mobile(),c=this.fingerprint_fonts(),h=this.fingerprint_fontsmoothing(),d=this.fingerprint_db(),u=this.fingerprint_canvas_1(),g=this.fingerprint_gl();return e.push(t),e.push(i),e.push(r),e.push(a),e.push(n),e.push(o),e.push(s),e.push(l),e.push(c),e.push(h),e.push(d),e.push(u),e.push(g),this.x64hash128(e.toString(),"affilae")},x64Add:function(e,t){e=[e[0]>>>16,65535&e[0],e[1]>>>16,65535&e[1]],t=[t[0]>>>16,65535&t[0],t[1]>>>16,65535&t[1]];var i=[0,0,0,0];return i[3]+=e[3]+t[3],i[2]+=i[3]>>>16,i[3]&=65535,i[2]+=e[2]+t[2],i[1]+=i[2]>>>16,i[2]&=65535,i[1]+=e[1]+t[1],i[0]+=i[1]>>>16,i[1]&=65535,i[0]+=e[0]+t[0],i[0]&=65535,[i[0]<<16|i[1],i[2]<<16|i[3]]},x64Multiply:function(e,t){e=[e[0]>>>16,65535&e[0],e[1]>>>16,65535&e[1]],t=[t[0]>>>16,65535&t[0],t[1]>>>16,65535&t[1]];var i=[0,0,0,0];return i[3]+=e[3]*t[3],i[2]+=i[3]>>>16,i[3]&=65535,i[2]+=e[2]*t[3],i[1]+=i[2]>>>16,i[2]&=65535,i[2]+=e[3]*t[2],i[1]+=i[2]>>>16,i[2]&=65535,i[1]+=e[1]*t[3],i[0]+=i[1]>>>16,i[1]&=65535,i[1]+=e[2]*t[2],i[0]+=i[1]>>>16,i[1]&=65535,i[1]+=e[3]*t[1],i[0]+=i[1]>>>16,i[1]&=65535,i[0]+=e[0]*t[3]+e[1]*t[2]+e[2]*t[1]+e[3]*t[0],i[0]&=65535,[i[0]<<16|i[1],i[2]<<16|i[3]]},x64Rotl:function(e,t){return 32===(t%=64)?[e[1],e[0]]:t<32?[e[0]<<t|e[1]>>>32-t,e[1]<<t|e[0]>>>32-t]:(t-=32,[e[1]<<t|e[0]>>>32-t,e[0]<<t|e[1]>>>32-t])},x64LeftShift:function(e,t){return 0===(t%=64)?e:t<32?[e[0]<<t|e[1]>>>32-t,e[1]<<t]:[e[1]<<t-32,0]},x64Xor:function(e,t){return[e[0]^t[0],e[1]^t[1]]},x64Fmix:function(e){return e=this.x64Xor(e,[0,e[0]>>>1]),e=this.x64Multiply(e,[4283543511,3981806797]),e=this.x64Xor(e,[0,e[0]>>>1]),e=this.x64Multiply(e,[3301882366,444984403]),e=this.x64Xor(e,[0,e[0]>>>1])},x64hash128:function(e,t){t=t||0;for(var i=(e=e||"").length%16,r=e.length-i,a=[0,t],n=[0,t],o=[0,0],s=[0,0],l=[2277735313,289559509],c=[1291169091,658871167],h=0;h<r;h+=16)o=[255&e.charCodeAt(h+4)|(255&e.charCodeAt(h+5))<<8|(255&e.charCodeAt(h+6))<<16|(255&e.charCodeAt(h+7))<<24,255&e.charCodeAt(h)|(255&e.charCodeAt(h+1))<<8|(255&e.charCodeAt(h+2))<<16|(255&e.charCodeAt(h+3))<<24],s=[255&e.charCodeAt(h+12)|(255&e.charCodeAt(h+13))<<8|(255&e.charCodeAt(h+14))<<16|(255&e.charCodeAt(h+15))<<24,255&e.charCodeAt(h+8)|(255&e.charCodeAt(h+9))<<8|(255&e.charCodeAt(h+10))<<16|(255&e.charCodeAt(h+11))<<24],o=this.x64Multiply(o,l),o=this.x64Rotl(o,31),o=this.x64Multiply(o,c),a=this.x64Xor(a,o),a=this.x64Rotl(a,27),a=this.x64Add(a,n),a=this.x64Add(this.x64Multiply(a,[0,5]),[0,1390208809]),s=this.x64Multiply(s,c),s=this.x64Rotl(s,33),s=this.x64Multiply(s,l),n=this.x64Xor(n,s),n=this.x64Rotl(n,31),n=this.x64Add(n,a),n=this.x64Add(this.x64Multiply(n,[0,5]),[0,944331445]);switch(o=[0,0],s=[0,0],i){case 15:s=this.x64Xor(s,this.x64LeftShift([0,e.charCodeAt(h+14)],48));case 14:s=this.x64Xor(s,this.x64LeftShift([0,e.charCodeAt(h+13)],40));case 13:s=this.x64Xor(s,this.x64LeftShift([0,e.charCodeAt(h+12)],32));case 12:s=this.x64Xor(s,this.x64LeftShift([0,e.charCodeAt(h+11)],24));case 11:s=this.x64Xor(s,this.x64LeftShift([0,e.charCodeAt(h+10)],16));case 10:s=this.x64Xor(s,this.x64LeftShift([0,e.charCodeAt(h+9)],8));case 9:s=this.x64Xor(s,[0,e.charCodeAt(h+8)]),s=this.x64Multiply(s,c),s=this.x64Rotl(s,33),s=this.x64Multiply(s,l),n=this.x64Xor(n,s);case 8:o=this.x64Xor(o,this.x64LeftShift([0,e.charCodeAt(h+7)],56));case 7:o=this.x64Xor(o,this.x64LeftShift([0,e.charCodeAt(h+6)],48));case 6:o=this.x64Xor(o,this.x64LeftShift([0,e.charCodeAt(h+5)],40));case 5:o=this.x64Xor(o,this.x64LeftShift([0,e.charCodeAt(h+4)],32));case 4:o=this.x64Xor(o,this.x64LeftShift([0,e.charCodeAt(h+3)],24));case 3:o=this.x64Xor(o,this.x64LeftShift([0,e.charCodeAt(h+2)],16));case 2:o=this.x64Xor(o,this.x64LeftShift([0,e.charCodeAt(h+1)],8));case 1:o=this.x64Xor(o,[0,e.charCodeAt(h)]),o=this.x64Multiply(o,l),o=this.x64Rotl(o,31),o=this.x64Multiply(o,c),a=this.x64Xor(a,o)}return a=this.x64Xor(a,[0,e.length]),n=this.x64Xor(n,[0,e.length]),a=this.x64Add(a,n),n=this.x64Add(n,a),a=this.x64Fmix(a),n=this.x64Fmix(n),a=this.x64Add(a,n),n=this.x64Add(n,a),("00000000"+(a[0]>>>0).toString(16)).slice(-8)+("00000000"+(a[1]>>>0).toString(16)).slice(-8)+("00000000"+(n[0]>>>0).toString(16)).slice(-8)+("00000000"+(n[1]>>>0).toString(16)).slice(-8)},fingerprint_useragent:function(){return navigator.userAgent.toLowerCase()},fingerprint_language:function(){return navigator.language},fingerprint_display:function(){var e,t="|",i=null;try{return(e=window.screen)&&(i=e.colorDepth+t+e.width+t+e.height+t+e.availWidth+t+e.availHeight),i}catch(e){return"Error"}},fingerprint_timezone:function(){try{return(new Date).getTimezoneOffset()/60*-1}catch(e){return"Error"}},fingerprint_os:function(){try{return navigator.platform.toLowerCase()}catch(e){return e}},fingerprint_donottrack:function(){return navigator.doNotTrack},fingerprint_cookie:function(){return navigator.cookieEnabled},fingerprint_canvas:function(){var e=null,t=null,i="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ`~1!2@3#4$5%6^7&8*9(0)-_=+[{]}|;:',<.>/?";try{return(t=(e=document.createElement("canvas")).getContext("2d")).textBaseline="top",t.font="14px 'Arial'",t.textBaseline="alphabetic",t.fillStyle="#f60",t.fillRect(125,1,62,20),t.fillStyle="#069",t.fillText(i,2,15),t.fillStyle="rgba(102, 204, 0, 0.7)",t.fillText(i,4,17),e.toDataURL()}catch(e){return""}},fingerprint_mobile:function(){var e,t=!1;return e=navigator.userAgent||navigator.vendor||window.opera,(/(android|bb\d+|meego).+mobile|avantgo|bada\/|blackberry|blazer|compal|elaine|fennec|hiptop|iemobile|ip(hone|od)|iris|kindle|lge |maemo|midp|mmp|mobile.+firefox|netfront|opera m(ob|in)i|palm( os)?|phone|p(ixi|re)\/|plucker|pocket|psp|series(4|6)0|symbian|treo|up\.(browser|link)|vodafone|wap|windows ce|xda|xiino|android|ipad|playbook|silk/i.test(e)||/1207|6310|6590|3gso|4thp|50[1-6]i|770s|802s|a wa|abac|ac(er|oo|s\-)|ai(ko|rn)|al(av|ca|co)|amoi|an(ex|ny|yw)|aptu|ar(ch|go)|as(te|us)|attw|au(di|\-m|r |s )|avan|be(ck|ll|nq)|bi(lb|rd)|bl(ac|az)|br(e|v)w|bumb|bw\-(n|u)|c55\/|capi|ccwa|cdm\-|cell|chtm|cldc|cmd\-|co(mp|nd)|craw|da(it|ll|ng)|dbte|dc\-s|devi|dica|dmob|do(c|p)o|ds(12|\-d)|el(49|ai)|em(l2|ul)|er(ic|k0)|esl8|ez([4-7]0|os|wa|ze)|fetc|fly(\-|_)|g1 u|g560|gene|gf\-5|g\-mo|go(\.w|od)|gr(ad|un)|haie|hcit|hd\-(m|p|t)|hei\-|hi(pt|ta)|hp( i|ip)|hs\-c|ht(c(\-| |_|a|g|p|s|t)|tp)|hu(aw|tc)|i\-(20|go|ma)|i230|iac( |\-|\/)|ibro|idea|ig01|ikom|im1k|inno|ipaq|iris|ja(t|v)a|jbro|jemu|jigs|kddi|keji|kgt( |\/)|klon|kpt |kwc\-|kyo(c|k)|le(no|xi)|lg( g|\/(k|l|u)|50|54|\-[a-w])|libw|lynx|m1\-w|m3ga|m50\/|ma(te|ui|xo)|mc(01|21|ca)|m\-cr|me(rc|ri)|mi(o8|oa|ts)|mmef|mo(01|02|bi|de|do|t(\-| |o|v)|zz)|mt(50|p1|v )|mwbp|mywa|n10[0-2]|n20[2-3]|n30(0|2)|n50(0|2|5)|n7(0(0|1)|10)|ne((c|m)\-|on|tf|wf|wg|wt)|nok(6|i)|nzph|o2im|op(ti|wv)|oran|owg1|p800|pan(a|d|t)|pdxg|pg(13|\-([1-8]|c))|phil|pire|pl(ay|uc)|pn\-2|po(ck|rt|se)|prox|psio|pt\-g|qa\-a|qc(07|12|21|32|60|\-[2-7]|i\-)|qtek|r380|r600|raks|rim9|ro(ve|zo)|s55\/|sa(ge|ma|mm|ms|ny|va)|sc(01|h\-|oo|p\-)|sdk\/|se(c(\-|0|1)|47|mc|nd|ri)|sgh\-|shar|sie(\-|m)|sk\-0|sl(45|id)|sm(al|ar|b3|it|t5)|so(ft|ny)|sp(01|h\-|v\-|v )|sy(01|mb)|t2(18|50)|t6(00|10|18)|ta(gt|lk)|tcl\-|tdg\-|tel(i|m)|tim\-|t\-mo|to(pl|sh)|ts(70|m\-|m3|m5)|tx\-9|up(\.b|g1|si)|utst|v400|v750|veri|vi(rg|te)|vk(40|5[0-3]|\-v)|vm40|voda|vulc|vx(52|53|60|61|70|80|81|83|85|98)|w3c(\-| )|webc|whit|wi(g |nc|nw)|wmlb|wonu|x700|yas\-|your|zeto|zte\-/i.test(e.substr(0,4)))&&(t=!0),t},fingerprint_fonts:function(){var e,t,i,r,a,n=null,o=null,s=null,l=null,c=null,h=0;try{for(r=(i=["Abadi MT Condensed Light","Adobe Fangsong Std","Adobe Hebrew","Adobe Ming Std","Agency FB","Aharoni","Andalus","Angsana New","AngsanaUPC","Aparajita","Arab","Arabic Transparent","Arabic Typesetting","Arial Baltic","Arial Black","Arial CE","Arial CYR","Arial Greek","Arial TUR","Arial","Batang","BatangChe","Bauhaus 93","Bell MT","Bitstream Vera Serif","Bodoni MT","Bookman Old Style","Braggadocio","Broadway","Browallia New","BrowalliaUPC","Calibri Light","Calibri","Californian FB","Cambria Math","Cambria","Candara","Castellar","Casual","Centaur","Century Gothic","Chalkduster","Colonna MT","Comic Sans MS","Consolas","Constantia","Copperplate Gothic Light","Corbel","Cordia New","CordiaUPC","Courier New Baltic","Courier New CE","Courier New CYR","Courier New Greek","Courier New TUR","Courier New","DFKai-SB","DaunPenh","David","DejaVu LGC Sans Mono","Desdemona","DilleniaUPC","DokChampa","Dotum","DotumChe","Ebrima","Engravers MT","Eras Bold ITC","Estrangelo Edessa","EucrosiaUPC","Euphemia","Eurostile","FangSong","Forte","FrankRuehl","Franklin Gothic Heavy","Franklin Gothic Medium","FreesiaUPC","French Script MT","Gabriola","Gautami","Georgia","Gigi","Gisha","Goudy Old Style","Gulim","GulimChe","GungSeo","Gungsuh","GungsuhChe","Haettenschweiler","Harrington","Hei S","HeiT","Heisei Kaku Gothic","Hiragino Sans GB","Impact","Informal Roman","IrisUPC","Iskoola Pota","JasmineUPC","KacstOne","KaiTi","Kalinga","Kartika","Khmer UI","Kino MT","KodchiangUPC","Kokila","Kozuka Gothic Pr6N","Lao UI","Latha","Leelawadee","Levenim MT","LilyUPC","Lohit Gujarati","Loma","Lucida Bright","Lucida Console","Lucida Fax","Lucida Sans Unicode","MS Gothic","MS Mincho","MS PGothic","MS PMincho","MS Reference Sans Serif","MS UI Gothic","MV Boli","Magneto","Malgun Gothic","Mangal","Marlett","Matura MT Script Capitals","Meiryo UI","Meiryo","Menlo","Microsoft Himalaya","Microsoft JhengHei","Microsoft New Tai Lue","Microsoft PhagsPa","Microsoft Sans Serif","Microsoft Tai Le","Microsoft Uighur","Microsoft YaHei","Microsoft Yi Baiti","MingLiU","MingLiU-ExtB","MingLiU_HKSCS","MingLiU_HKSCS-ExtB","Miriam Fixed","Miriam","Mongolian Baiti","MoolBoran","NSimSun","Narkisim","News Gothic MT","Niagara Solid","Nyala","PMingLiU","PMingLiU-ExtB","Palace Script MT","Palatino Linotype","Papyrus","Perpetua","Plantagenet Cherokee","Playbill","Prelude Bold","Prelude Condensed Bold","Prelude Condensed Medium","Prelude Medium","PreludeCompressedWGL Black","PreludeCompressedWGL Bold","PreludeCompressedWGL Light","PreludeCompressedWGL Medium","PreludeCondensedWGL Black","PreludeCondensedWGL Bold","PreludeCondensedWGL Light","PreludeCondensedWGL Medium","PreludeWGL Black","PreludeWGL Bold","PreludeWGL Light","PreludeWGL Medium","Raavi","Rachana","Rockwell","Rod","Sakkal Majalla","Sawasdee","Script MT Bold","Segoe Print","Segoe Script","Segoe UI Light","Segoe UI Semibold","Segoe UI Symbol","Segoe UI","Shonar Bangla","Showcard Gothic","Shruti","SimHei","SimSun","SimSun-ExtB","Simplified Arabic Fixed","Simplified Arabic","Snap ITC","Sylfaen","Symbol","Tahoma","Times New Roman Baltic","Times New Roman CE","Times New Roman CYR","Times New Roman Greek","Times New Roman TUR","Times New Roman","TlwgMono","Traditional Arabic","Trebuchet MS","Tunga","Tw Cen MT Condensed Extra Bold","Ubuntu","Umpush","Univers","Utopia","Utsaah","Vani","Verdana","Vijaya","Vladimir Script","Vrinda","Webdings","Wide Latin","Wingdings"]).length,o="<b style=\"display:inline !important; width:auto !important; font:normal 10px/1 'X',sans-serif !important\">ww</b><b style=\"display:inline !important; width:auto !important; font:normal 10px/1 'X',monospace !important\">ww</b>",e=document.createDocumentFragment(),s=[],h=0;h<r;h+=1)n=i[h],l=document.createElement("div"),n=n.replace(/['"<>]/g,""),l.innerHTML=o.replace(/X/g,n),l.style.cssText="position: absolute; visibility: hidden; display: block !important",e.appendChild(l),s.push(l);for((c=document.body).insertBefore(e,c.firstChild),t=[],h=0;h<r;h+=1)(a=s[h].getElementsByTagName("b"))[0].offsetWidth===a[1].offsetWidth&&t.push(i[h]);for(h=0;h<r;h+=1)c.removeChild(s[h]);return t.join("|")}catch(e){return"Error"}},fingerprint_fontsmoothing:function(){var e,t,i,r=null,a=null,n=null;if(void 0!==screen.fontSmoothingEnabled)r=screen.fontSmoothingEnabled;else try{for(fontsmoothing="false",(a=document.createElement("canvas")).width="35",a.height="35",a.style.display="none",document.body.appendChild(a),(n=a.getContext("2d")).textBaseline="top",n.font="32px Arial",n.fillStyle="black",n.strokeStyle="black",n.fillText("O",0,0),t=8;t<=32;t+=1)for(e=1;e<=32;e+=1)255!==(i=n.getImageData(e,t,1,1).data[3])&&0!==i&&(r="true");0}catch(e){return"Unknown"}return r},fingerprint_db:function(){return!!window.indexedDB},fingerprint_canvas_1:function(){var e=[],t=document.createElement("canvas");t.width=2e3,t.height=200,t.style.display="inline";var i=t.getContext("2d");return i.rect(0,0,10,10),i.rect(2,2,6,6),e.push("canvas winding:"+(!1===i.isPointInPath(5,5,"evenodd")?"yes":"no")),i.textBaseline="alphabetic",i.fillStyle="#f60",i.fillRect(125,1,62,20),i.fillStyle="#069",i.font="11pt no-real-font-123",i.fillText("Cwm fjordbank glyphs vext quiz, 😃",2,15),i.fillStyle="rgba(102, 204, 0, 0.2)",i.font="18pt Arial",i.fillText("Cwm fjordbank glyphs vext quiz, 😃",4,45),i.globalCompositeOperation="multiply",i.fillStyle="rgb(255,0,255)",i.beginPath(),i.arc(50,50,50,0,2*Math.PI,!0),i.closePath(),i.fill(),i.fillStyle="rgb(0,255,255)",i.beginPath(),i.arc(100,50,50,0,2*Math.PI,!0),i.closePath(),i.fill(),i.fillStyle="rgb(255,255,0)",i.beginPath(),i.arc(75,100,50,0,2*Math.PI,!0),i.closePath(),i.fill(),i.fillStyle="rgb(255,0,255)",i.arc(75,75,75,0,2*Math.PI,!0),i.arc(75,75,25,0,2*Math.PI,!0),i.fill("evenodd"),t.toDataURL&&e.push("canvas fp:"+t.toDataURL()),e},fingerprint_gl:function(){function e(e){return n.clearColor(0,0,0,1),n.enable(n.DEPTH_TEST),n.depthFunc(n.LEQUAL),n.clear(n.COLOR_BUFFER_BIT|n.DEPTH_BUFFER_BIT),"["+e[0]+", "+e[1]+"]"}var t=document.createElement("canvas"),n=null;try{n=t.getContext("webgl")||t.getContext("experimental-webgl")}catch(e){}if(!n)return null;function o(e,t){if(Array.prototype.forEach&&e.forEach===Array.prototype.forEach)e.forEach(t);else if(e.length===+e.length)for(var i=0,r=e.length;i<r;i++)t(e[i],i,e);else for(var a in e)e.hasOwnProperty(a)&&t(e[a],a,e)}var s=[],i=n.createBuffer();n.bindBuffer(n.ARRAY_BUFFER,i);var r=new Float32Array([-.2,-.9,0,.4,-.26,0,0,.732134444,0]);n.bufferData(n.ARRAY_BUFFER,r,n.STATIC_DRAW),i.itemSize=3,i.numItems=3;var a=n.createProgram(),l=n.createShader(n.VERTEX_SHADER);n.shaderSource(l,"attribute vec2 attrVertex;varying vec2 varyinTexCoordinate;uniform vec2 uniformOffset;void main(){varyinTexCoordinate=attrVertex+uniformOffset;gl_Position=vec4(attrVertex,0,1);}"),n.compileShader(l);r=n.createShader(n.FRAGMENT_SHADER);n.shaderSource(r,"precision mediump float;varying vec2 varyinTexCoordinate;void main() {gl_FragColor=vec4(varyinTexCoordinate,0,1);}"),n.compileShader(r),n.attachShader(a,l),n.attachShader(a,r),n.linkProgram(a),n.useProgram(a),a.vertexPosAttrib=n.getAttribLocation(a,"attrVertex"),a.offsetUniform=n.getUniformLocation(a,"uniformOffset"),n.enableVertexAttribArray(a.vertexPosArray),n.vertexAttribPointer(a.vertexPosAttrib,i.itemSize,n.FLOAT,!1,0,0),n.uniform2f(a.offsetUniform,1,1),n.drawArrays(n.TRIANGLE_STRIP,0,i.numItems);try{s.push(n.canvas.toDataURL())}catch(e){}s.push("extensions:"+(n.getSupportedExtensions()||[]).join(";")),s.push("webgl aliased line width range:"+e(n.getParameter(n.ALIASED_LINE_WIDTH_RANGE))),s.push("webgl aliased point size range:"+e(n.getParameter(n.ALIASED_POINT_SIZE_RANGE))),s.push("webgl alpha bits:"+n.getParameter(n.ALPHA_BITS)),s.push("webgl antialiasing:"+(n.getContextAttributes().antialias?"yes":"no")),s.push("webgl blue bits:"+n.getParameter(n.BLUE_BITS)),s.push("webgl depth bits:"+n.getParameter(n.DEPTH_BITS)),s.push("webgl green bits:"+n.getParameter(n.GREEN_BITS)),s.push("webgl max anisotropy:"+function(e){var t=e.getExtension("EXT_texture_filter_anisotropic")||e.getExtension("WEBKIT_EXT_texture_filter_anisotropic")||e.getExtension("MOZ_EXT_texture_filter_anisotropic");if(t){t=e.getParameter(t.MAX_TEXTURE_MAX_ANISOTROPY_EXT);return 0===t&&(t=2),t}return null}(n)),s.push("webgl max combined texture image units:"+n.getParameter(n.MAX_COMBINED_TEXTURE_IMAGE_UNITS)),s.push("webgl max cube map texture size:"+n.getParameter(n.MAX_CUBE_MAP_TEXTURE_SIZE)),s.push("webgl max fragment uniform vectors:"+n.getParameter(n.MAX_FRAGMENT_UNIFORM_VECTORS)),s.push("webgl max render buffer size:"+n.getParameter(n.MAX_RENDERBUFFER_SIZE)),s.push("webgl max texture image units:"+n.getParameter(n.MAX_TEXTURE_IMAGE_UNITS)),s.push("webgl max texture size:"+n.getParameter(n.MAX_TEXTURE_SIZE)),s.push("webgl max varying vectors:"+n.getParameter(n.MAX_VARYING_VECTORS)),s.push("webgl max vertex attribs:"+n.getParameter(n.MAX_VERTEX_ATTRIBS)),s.push("webgl max vertex texture image units:"+n.getParameter(n.MAX_VERTEX_TEXTURE_IMAGE_UNITS)),s.push("webgl max vertex uniform vectors:"+n.getParameter(n.MAX_VERTEX_UNIFORM_VECTORS)),s.push("webgl max viewport dims:"+e(n.getParameter(n.MAX_VIEWPORT_DIMS))),s.push("webgl red bits:"+n.getParameter(n.RED_BITS)),s.push("webgl renderer:"+n.getParameter(n.RENDERER)),s.push("webgl shading language version:"+n.getParameter(n.SHADING_LANGUAGE_VERSION)),s.push("webgl stencil bits:"+n.getParameter(n.STENCIL_BITS)),s.push("webgl vendor:"+n.getParameter(n.VENDOR)),s.push("webgl version:"+n.getParameter(n.VERSION));try{var c=n.getExtension("WEBGL_debug_renderer_info");c&&(s.push("webgl unmasked vendor:"+n.getParameter(c.UNMASKED_VENDOR_WEBGL)),s.push("webgl unmasked renderer:"+n.getParameter(c.UNMASKED_RENDERER_WEBGL)))}catch(e){}return n.getShaderPrecisionFormat&&o(["FLOAT","INT"],function(a){o(["VERTEX","FRAGMENT"],function(r){o(["HIGH","MEDIUM","LOW"],function(i){o(["precision","rangeMin","rangeMax"],function(e){var t=n.getShaderPrecisionFormat(n[r+"_SHADER"],n[i+"_"+a])[e];"precision"!==e&&(e="precision "+e);t=["webgl ",r.toLowerCase()," shader ",i.toLowerCase()," ",a.toLowerCase()," ",e,":",t].join("");s.push(t)})})})}),s}};var AeTracker={readyStateCheckInterval:null,isAdvertiserFirst:0,initTime:0,init:function(e){return e="object"==typeof e&&null!==e?e:{},this.prepare(e),24!=this.pid.length?(this.log("Wrong PID: "+this.pid,3),!1):(!1===this.allowIframing&&top.location!=location&&(top.location.href=document.location.href),!this.forceReferrer||void 0!==document.referrer&&0!==document.referrer.length?(this.log("Referer: "+document.referrer,3),void(this.readyStateCheckInterval=setInterval(AeTracker.checkReadyState,100))):(this.log("No referer. Exiting",3),!1))},prepare:function(e){this.version="3.5.12",this.pid=e.pid||0,this.host=e.host||"https://lb.affilae.com",this.advertiserFirst=e.advertiserFirst||0!==e.advertiserFirst?21600:0,this.cookieExpiration=e.cookieExpiration||43200,this.allowSiteUnder=e.allowSiteUnder||!1,this.allowIframing=e.allowIframing||!0,this.forceReferrer=e.forceReferrer||!1,this.tagType=e.tagType||"pixel",this.fp=e.fp||!0,this.firstParty=e.firstParty||!0,this.ip=e.ip||null,this.tracker=e.tracker||null,this.affiliateID=null,this.adID=null,this.ptID=null,this.customVar=e.customVar||"",this.debug=e.debug||!1,this.skipMouse=e.skipMouse||!1,this.timerLimit=e.timerLimit||10,this.cookieNameForAdvertiserFirst=e.cookieNameForAdvertiserFirst||"AeFirst",this.referrer=e.referrer||"",this.debugId=e.debugId||"aeDebug",this.fpTracker=new t},checkReadyState:function(){if("complete"===document.readyState||"interactive"===document.readyState){clearInterval(AeTracker.readyStateCheckInterval),AeTracker.log("Document is ready",3);var e=new String(window.location),e=new RegExp("(\\?|&)+aedebug=([^&|#]+)").exec(e);if(e&&2<e.length&&(AeTracker.debug=parseInt(e[2])),AeTracker.initTime=(new Date).getTime(),AeTracker.log("User Agent: "+navigator.userAgent,3),AeTracker.log("Cookie Enabled: "+AeTracker.fpTracker.fingerprint_cookie(),3),AeTracker.log("Is Mobile: "+AeTracker.fpTracker.fingerprint_mobile(),3),!0===AeTracker.skipMouse||!0===AeTracker.fpTracker.fingerprint_mobile()||!0===AeTracker.allowSiteUnder?AeTracker.execute():null!=document.addEventListener?document.addEventListener("mousemove",AeTracker.checkTimer,!0):document.attachEvent("onmousemove",AeTracker.checkTimer),"AE"in window)if(AE instanceof Array){for(var t=AE,i=0;i<t.length;i++)AE=t[i],AeTracker.sendConversion();AE=[]}else AeTracker.sendConversion()}},execute:function(){var e;this.log("Tracking Start",3),console.time("AE Tracking - Execution"),this.tracker||this.findTracker(),this.tracker?this.initTracking():this.log("No Tracking found",2),null==this.readCookie(this.cookieNameForAdvertiserFirst+this.pid)&&0<this.advertiserFirst&&(e=new Date,this.createCookie(this.cookieNameForAdvertiserFirst+this.pid,e.getTime(),this.advertiserFirst)),this.tracker||this.detachTimerEvent(),console.timeEnd("AE Tracking - Execution"),this.log("Tracking Stop",3)},initTracking:function(){this.detachTimerEvent();var e=this.tracker.split("-");void 0===e[1]&&(e[1]=""),this.affiliateID=e[0],this.adID=e[1],this.log("Affiliate ID found: "+this.affiliateID,2),this.log("Ad ID found: "+this.adID,3),this.log("Sub ID found: "+this.customVar,3),this.log("Product ID found: "+this.ptID,3),document.referrer&&(this.referrer=document.referrer);e=this.readCookie(this.cookieNameForAdvertiserFirst+this.pid);e&&"false"!=e&&(this.isAdvertiserFirst=1);var r,e=this.buildClickURL(e);this.log("Sending Click",3),this.firstParty?((r=new XMLHttpRequest).open("GET",e),r.onreadystatechange=function(){var e,t,i;r.readyState!==XMLHttpRequest.DONE&&4!==r.readyState||((e=r.responseText).match(/^[a-f\d]{24}$/i)?(AeTracker.log("Tracking Click: "+e+" 🐾",1),t="_affilae"+AeTracker.pid,i=e,AeTracker.readCookie(t)&&(i=(i=AeTracker.readCookie(t))+"-"+e),AeTracker.createCookie(t,i,AeTracker.cookieExpiration)):AeTracker.log("Tracking Click: "+e+" 🐼",1))},r.send()):this.debug?this.injectIframe(e,2,50,400,""):this.injectIframe(e,0,0,0,"position: absolute;"),!this.readCookie(this.cookieNameForAdvertiserFirst+this.pid)&&0<this.advertiserFirst&&this.createCookie(this.cookieNameForAdvertiserFirst+this.pid,!1,this.advertiserFirst)},buildClickURL:function(e){var t,i="";return this.affiliateID&&(t="",this.fp&&(t="&fp="+this.fpTracker.generate()),i=this.host+"/?p="+this.pid+"&lp="+encodeURIComponent(document.location.href)+"&af="+this.affiliateID+"&ad="+this.adID+"&cv="+encodeURIComponent(this.customVar)+"&advfirst="+this.isAdvertiserFirst+"&advtime="+e+"&r="+encodeURIComponent(this.referrer)+t+"&pt="+this.ptID+"&v="+this.version,this.log("Click URL: "+i,3)),i},buildConversionURL:function(e){"undefined"==typeof AE||e||(e=AE);var t="";this.fp&&(t=this.fpTracker.generate()),void 0===e.Conversion.voucher&&(e.Conversion.voucher=""),void 0===e.Conversion.currency&&(e.Conversion.currency=""),void 0===e.Conversion.subid&&(e.Conversion.subid="");var i=e.key.split("-")[1];this.log("ProgramId From Rule: "+i,3);var r="_affilae"+i,i="";AeTracker.readCookie(r)&&0<AeTracker.readCookie(r).length&&(i=AeTracker.readCookie(r));i=this.host+"/?key="+e.key+"&id="+e.Conversion.id+"&amount="+e.Conversion.amount+"&cv="+e.Conversion.subid+"&payment="+e.Conversion.payment+"&voucher="+e.Conversion.voucher+"&currency="+e.Conversion.currency+"&fp="+t+"&cids="+i+"&v="+this.version;return this.log("Conversion URL: "+i,3),i},injectIframe:function(e,t,i,r,a){this.log("Injecting iframe: "+e,3);var n=document.createElement("iframe");n.setAttribute("src",e),n.setAttribute("id","iframe-affilae"),n.setAttribute("frameborder",t),n.setAttribute("height",i),n.setAttribute("width",r),n.setAttribute("style",a),document.getElementsByTagName("body")[0].appendChild(n)},injectPixel:function(e,t,i,r,a){this.log("Injecting pixel: "+e,3);var n=document.createElement("img");n.setAttribute("src",e),n.setAttribute("id","pixel-affilae"),n.setAttribute("frameborder",t),n.setAttribute("height",i),n.setAttribute("width",r),n.setAttribute("style",a),document.getElementsByTagName("body")[0].appendChild(n)},findTracker:function(){var e,t,i,r,a=new String(window.location);-1!=a.indexOf("#")&&(this.log('Searching IDs in "#"',3),e=a.split("#")[1],this.log("Found: "+e,3),this.ptID||(i=(i=new RegExp("(aept=|aept)([^&]+)")).exec(e))&&(this.ptID=i[2]),this.customVar||(r=(r=new RegExp("(aev=|aev)([^&]+)")).exec(e))&&(this.customVar=r[2]),null!=(t=(t=new RegExp("ae([^&]+)")).exec(e))&&(this.tracker=t[1])),this.tracker||-1!=a.indexOf("?")&&(this.log('Searching IDs in "?"',3),null!=(t=(t=new RegExp("(\\?|&)+ae=([^&|#]+)")).exec(a))&&(this.tracker=t[2]),this.ptID||(i=(i=new RegExp("(\\?|&)+aept=([^&|#]+)")).exec(a))&&(this.ptID=i[2]),this.customVar||(r=(r=new RegExp("(\\?|&)+aev=([^&|#]+)")).exec(a))&&(this.customVar=r[2]))},createCookie:function(e,t,i){this.log("Creating Cookie: "+e+" value : "+t,3);var r,a="";i&&((r=new Date).setTime(r.getTime()+60*i*1e3),a="; expires="+r.toGMTString()),document.cookie=e+"="+t+a+"; samesite=lax; path=/"},readCookie:function(e){this.log("Reading Cookie: "+e,3);for(var t,i=e+"=",r=document.cookie.split(";"),a=0;a<r.length;a++){for(t=r[a];" "==t.charAt(0);)t=t.substring(1,t.length);if(0==t.indexOf(i))return t.substring(i.length,t.length)}return this.log("Cookie not found: "+e,3),null},detachTimerEvent:function(){null!=document.removeEventListener?document.removeEventListener("mousemove",AeTracker.checkTimer,!0):document.detachEvent("onmousemove",AeTracker.checkTimer)},checkTimer:function(){AeTracker.log("Mouse activity",3),(new Date).getTime()-AeTracker.initTime<1e3*AeTracker.timerLimit&&AeTracker.execute(),AeTracker.detachTimerEvent()},log:function(e,t){var i,r,a;AeTracker.debug&&(("complete"===document.readyState||"interactive"===document.readyState)&&1<AeTracker.debug&&AeTracker.debug>=t&&(document.getElementById(AeTracker.debugId)?i=document.getElementById(AeTracker.debugId):((i=document.createElement("div")).setAttribute("style",'overflow-y: auto; font-weight: 300; font-family: "Lucida Sans Unicode", "Lucida Grande", sans-serif; color: #111111; font-size: 14px; background-color: #EEEEEE; padding: 0px 0 0 0px; border-top: 2px solid #5D6F79; bottom: 0; display: inline; height: 35%; left: 0; margin: 0; top: initial; opacity: 1; position: fixed; visibility: visible; width: 100%; z-index: 99999;'),(a=document.createElement("div")).setAttribute("style","box-shadow: -2px 4px 7px gray; background-color: #223946; width:100%; margin-bottom:10px; padding:3px 0 3px 3px; border-bottom: 2px solid #5D6F79"),(r=document.createElement("img")).setAttribute("src","https://static.affilae.com/misc/logo/ae.png"),r.setAttribute("style","width:36px;"),(t=document.createElement("div")).setAttribute("style","color:white; font-size: 17px;"),t.appendChild(r),t.appendChild(document.createTextNode(" Logs v"+AeTracker.version)),a.appendChild(t),i.appendChild(a),i.setAttribute("id",AeTracker.debugId)),a=("0"+(a=new Date).getHours()).slice(-2)+":"+("0"+a.getMinutes()).slice(-2)+":"+("0"+a.getSeconds()).slice(-2)+"."+("000"+a.getMilliseconds()).slice(-3),i.innerHTML+="&nbsp <b>"+a+"</b> &nbsp;"+e+"<br/>",document.body.appendChild(i)),console.log("AE Tracking - "+e))},sendClick:function(e){var t="object"==typeof(t=_ae)&&null!==t?t:{};e&&(t.tracker=e),this.prepare(t),AeTracker.execute()},sendConversion:function(e){e||"undefined"!=typeof AE&&AE.Conversion?(e=AeTracker.buildConversionURL(e),this.log("Sending conversion: "+e,2),"iframe"===this.tagType?this.debug?this.injectIframe(e,2,50,400,""):this.injectIframe(e,0,0,0,"position: absolute;"):this.debug?this.injectPixel(e,2,50,400,""):this.injectPixel(e,0,0,0,"display: none;")):this.log("No Conversion Info Found",3)}};try{AeTracker.init(_ae)}catch(e){}}