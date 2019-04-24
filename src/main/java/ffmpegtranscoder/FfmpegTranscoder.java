package ffmpegtranscoder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.math.Fraction;

import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.FFmpegExecutor;
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.builder.FFmpegBuilder;
import transcoder.Transcoder;

public class FfmpegTranscoder implements Transcoder {

	@Override
	public void transcode(String src, String tgt) throws IOException{
		/*
		String format = "";
		int pointer=0;
		for(int i=0;i<tgt.length();i++) {
			if(tgt.charAt(i) == '.') {
				pointer  = i;
				break;
			}
		}
		for(int i=pointer+1;i<tgt.length();i++) {
			format = format + tgt.charAt(i);
		}
		//System.out.println(format);*/
		
		FFmpeg ffmpeg = new FFmpeg("C:\\Users\\함석현\\eclipse-workspace\\ffmpeg\\bin\\ffmpeg");
		FFprobe ffprobe = new FFprobe("C:\\Users\\함석현\\eclipse-workspace\\ffmpeg\\bin\\ffprob");
		FFmpegBuilder builder = new FFmpegBuilder()
                .overrideOutputFiles(true)
                .addInput(src)     
                .addOutput(tgt) 
                .addExtraArgs("-an") 
                .done();    
         
        FFmpegExecutor excutor = new FFmpegExecutor(ffmpeg, ffprobe);
        excutor.createJob(builder).run();

		System.out.println(
				"Transcode the file in " + src + " using FF-MPEG. The transformed file is saved in " + tgt + ".");
	}
}