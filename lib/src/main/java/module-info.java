module lib 
{
	requires com.fasterxml.jackson.core;
	requires transitive com.fasterxml.jackson.databind;
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.controls;
	requires javafx.media;
	requires com.fasterxml.jackson.annotation;
	
	opens org.openjfx to javafx.fxml;
	exports org.openjfx;
	exports cvs.app;
	exports cvs.state;
}