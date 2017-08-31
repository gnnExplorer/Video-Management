package com.zhiyou100.vm.service;

import com.zhiyou100.vm.model.Speaker;
import com.zhiyou100.vm.util.Page;

public interface SpeakerService {

	Page<Speaker> viewSpeaker(String nameKey, String jobKey, Integer page);

	void addSpeaker(Speaker speaker);

	void deleteSpeaker(Speaker speaker);

	Speaker findSpeaker(Speaker s);

	void editSpeaker(Speaker speaker);

	Speaker findSpeakerById(Integer speakerId);

}
