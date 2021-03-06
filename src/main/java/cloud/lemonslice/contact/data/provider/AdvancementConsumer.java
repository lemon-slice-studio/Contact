package cloud.lemonslice.contact.data.provider;

import cloud.lemonslice.contact.common.block.BlockRegistry;
import cloud.lemonslice.contact.common.item.ItemRegistry;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.criterion.ImpossibleTrigger;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TranslationTextComponent;

import java.util.function.Consumer;

public final class AdvancementConsumer implements Consumer<Consumer<Advancement>>
{
    @Override
    public void accept(Consumer<Advancement> consumer)
    {
        Advancement root = Advancement.Builder.advancement()
                .display(ItemRegistry.MAIL,
                        new TranslationTextComponent("advancements.contact.root.title"),
                        new TranslationTextComponent("advancements.contact.root.description"),
                        new ResourceLocation("textures/gui/advancements/backgrounds/stone.png"),
                        FrameType.TASK, true, true, false)
                .addCriterion("impossible", new ImpossibleTrigger.Instance())
                .save(consumer, "contact:root");
        Advancement receivePostcard = Advancement.Builder.advancement()
                .parent(root)
                .display(ItemRegistry.OPENED_MAIL,
                        new TranslationTextComponent("advancements.contact.receive_postcard.title"),
                        new TranslationTextComponent("advancements.contact.receive_postcard.description"),
                        null, FrameType.TASK, true, true, false)
                .addCriterion("impossible", new ImpossibleTrigger.Instance())
                .save(consumer, "contact:receive_postcard");
        Advancement sendPostcard = Advancement.Builder.advancement()
                .parent(root)
                .display(ItemRegistry.POSTCARD,
                        new TranslationTextComponent("advancements.contact.send_postcard.title"),
                        new TranslationTextComponent("advancements.contact.send_postcard.description"),
                        null, FrameType.TASK, true, true, false)
                .addCriterion("impossible", new ImpossibleTrigger.Instance())
                .save(consumer, "contact:send_postcard");
        Advancement sendInPerson = Advancement.Builder.advancement()
                .parent(sendPostcard)
                .display(BlockRegistry.WHITE_MAILBOX_ITEM,
                        new TranslationTextComponent("advancements.contact.send_in_person.title"),
                        new TranslationTextComponent("advancements.contact.send_in_person.description"),
                        null, FrameType.GOAL, true, true, false)
                .addCriterion("impossible", new ImpossibleTrigger.Instance())
                .save(consumer, "contact:send_in_person");
        Advancement fromAnotherWorld = Advancement.Builder.advancement()
                .parent(receivePostcard)
                .display(ItemRegistry.PARCEL,
                        new TranslationTextComponent("advancements.contact.from_another_world.title"),
                        new TranslationTextComponent("advancements.contact.from_another_world.description"),
                        null, FrameType.TASK, true, true, false)
                .addCriterion("impossible", new ImpossibleTrigger.Instance())
                .save(consumer, "contact:from_another_world");
    }
}
