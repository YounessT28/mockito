<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
	<head> 
        <meta charset="UTF-8">
		<link  id='GoogleFontsLink' href='https://fonts.googleapis.com/css?family=Open Sans' rel='stylesheet' type='text/css'>
        <script>
        WebFontConfig = {
        google: 
        {families: ["Open Sans",]},active: function() { 
        DrawTheChart(ChartData,ChartOptions,"chart-01","Bar")}
        };
		</script>
		<script asyn src="https://charts.livegap.com/js/webfont.js">
		</script><script src="https://charts.livegap.com/js/Chart.min.js"></script>
		<script>
        function DrawTheChart(ChartData,ChartOptions,ChartId,ChartType){
        eval('var myLine = new Chart(document.getElementById(ChartId).getContext("2d")).'+ChartType+'(ChartData,ChartOptions);document.getElementById(ChartId).getContext("2d").stroke();')
        }
		</script>
	</head>
	<body style="display:flex; justify-content: center;">
        <canvas  id="chart-01" width="875" height="500"  style="background-color:rgba(255,255,255,1.00);border-radius:0px;width:700px;height:400px;padding-left:0px;padding-right:0px;padding-top:0px;padding-bottom:0px"></canvas>
		<script> 
        function MoreChartOptions(){} 
        
        var ChartData = {labels : ["Jean","Mark","Bernard","Jules","Theo","Paul","Ander",],datasets : [{fillColor :"rgba(52,152,219,1)",strokeColor : "rgba(52,152,219,0.5)",pointColor : "rgba(52,152,219,1)",markerShape :"circle",pointStrokeColor : "rgba(255,255,255,1.00)",data : [15,12,11,13,19,8,16,],title:"Notes"},]};ChartOptions= {decimalSeparator:".",thousandSeparator:",",spaceLeft:12,spaceRight:12,spaceTop:12,spaceBottom:12,scaleLabel:"<%=value+''%>",yAxisMinimumInterval:1,scaleShowLabels:true,scaleShowLine:true,scaleLineStyle:"solid",scaleLineWidth:1,scaleLineColor:"rgba(0,0,0,0.6)",scaleOverlay :false,scaleOverride :false,scaleSteps:10,scaleStepWidth:10,scaleStartValue:0,inGraphDataShow:true,inGraphDataTmpl:'<%=v3%>',inGraphDataFontFamily:"'Open Sans'",inGraphDataFontStyle:"normal bold",inGraphDataFontColor:"rgba(255,255,255,1.00)",inGraphDataFontSize:12,inGraphDataPaddingX:0,inGraphDataPaddingY:-5,inGraphDataAlign:"center",inGraphDataVAlign:"top",inGraphDataXPosition:2,inGraphDataYPosition:3,inGraphDataAnglePosition:2,inGraphDataRadiusPosition:2,inGraphDataRotate:0,inGraphDataPaddingAngle:0,inGraphDataPaddingRadius:0, inGraphDataBorders:false,inGraphDataBordersXSpace:1,inGraphDataBordersYSpace:1,inGraphDataBordersWidth:1,inGraphDataBordersStyle:"solid",inGraphDataBordersColor:"rgba(0,0,0,1)",legend:true,maxLegendCols:5,legendBlockSize:15,legendFillColor:'rgba(255,255,255,0.00)',legendColorIndicatorStrokeWidth:1,legendPosX:-2,legendPosY:4,legendXPadding:0,legendYPadding:0,legendBorders:false,legendBordersWidth:1,legendBordersStyle:"solid",legendBordersColors:"rgba(102,102,102,1)",legendBordersSpaceBefore:5,legendBordersSpaceLeft:5,legendBordersSpaceRight:5,legendBordersSpaceAfter:5,legendSpaceBeforeText:5,legendSpaceLeftText:5,legendSpaceRightText:5,legendSpaceAfterText:5,legendSpaceBetweenBoxAndText:5,legendSpaceBetweenTextHorizontal:5,legendSpaceBetweenTextVertical:5,legendFontFamily:"'Open Sans'",legendFontStyle:"normal normal",legendFontColor:"rgba(0,0,0,1)",legendFontSize:15,showYAxisMin:false,rotateLabels:"smart",xAxisBottom:true,yAxisLeft:true,yAxisRight:false,graphTitleSpaceBefore:5,graphTitleSpaceAfter:5, graphTitleBorders:false,graphTitleBordersXSpace:1,graphTitleBordersYSpace:1,graphTitleBordersWidth:1,graphTitleBordersStyle:"solid",graphTitleBordersColor:"rgba(0,0,0,1)",graphTitle : "Moyennes",graphTitleFontFamily:"'Open Sans'",graphTitleFontStyle:"normal normal",graphTitleFontColor:"rgba(52,152,219,1)",graphTitleFontSize:26,graphSubTitleSpaceBefore:5,graphSubTitleSpaceAfter:5, graphSubTitleBorders:false,graphSubTitleBordersXSpace:1,graphSubTitleBordersYSpace:1,graphSubTitleBordersWidth:1,graphSubTitleBordersStyle:"solid",graphSubTitleBordersColor:"rgba(0,0,0,1)",graphSubTitle : "Statistiques de toutes les moyennes",graphSubTitleFontFamily:"'Open Sans'",graphSubTitleFontStyle:"normal normal",graphSubTitleFontColor:"rgba(102,102,102,1)",graphSubTitleFontSize:16,scaleFontFamily:"'Open Sans'",scaleFontStyle:"normal normal",scaleFontColor:"rgba(0,0,0,1)",scaleFontSize:12,pointLabelFontFamily:"'Open Sans'",pointLabelFontStyle:"normal normal",pointLabelFontColor:"rgba(102,102,102,1)",pointLabelFontSize:12,angleShowLineOut:true,angleLineStyle:"solid",angleLineWidth:1,angleLineColor:"rgba(0,0,0,0.1)",percentageInnerCutout:50,scaleShowGridLines:true,scaleGridLineStyle:"solid",scaleGridLineWidth:1,scaleGridLineColor:"rgba(0,0,0,0.1)",scaleXGridLinesStep:1,scaleYGridLinesStep:3,segmentShowStroke:true,segmentStrokeStyle:"solid",segmentStrokeWidth:2,segmentStrokeColor:"rgba(255,255,255,1.00)",datasetStroke:true,datasetFill : true,datasetStrokeStyle:"solid",datasetStrokeWidth:2,bezierCurve:true,bezierCurveTension :0.4,pointDotStrokeStyle:"solid",pointDotStrokeWidth : 1,pointDotRadius : 3,pointDot : true,scaleTickSizeBottom:5,scaleTickSizeTop:5,scaleTickSizeLeft:5,scaleTickSizeRight:5,graphMin:0,barShowStroke : false,barBorderRadius:0,barStrokeStyle:"solid",barStrokeWidth:1,barValueSpacing:15,barDatasetSpacing:0,scaleShowLabelBackdrop :true,scaleBackdropColor:'rgba(255,255,255,0.75)',scaleBackdropPaddingX :2,scaleBackdropPaddingY :2,animation : false,onAnimationComplete : function(){MoreChartOptions()}};
 DrawTheChart(ChartData,ChartOptions,"chart-01","Bar");
        </script>
        
    </body>
</html>