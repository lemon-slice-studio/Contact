package cloud.lemonslice.contact.common.tileentity;

import cloud.lemonslice.contact.registry.RegistryModule;
import net.minecraft.tileentity.TileEntityType;

import static cloud.lemonslice.contact.common.block.BlockRegistry.*;

public final class TileEntityTypeRegistry extends RegistryModule
{
    public static final TileEntityType<MailboxTileEntity> MAILBOX =
            (TileEntityType<MailboxTileEntity>) TileEntityType.Builder.of(MailboxTileEntity::new,
                            ORANGE_MAILBOX, MAGENTA_MAILBOX, LIGHT_BLUE_MAILBOX, YELLOW_MAILBOX,
                            LIME_MAILBOX, PINK_MAILBOX, GRAY_MAILBOX, LIGHT_GRAY_MAILBOX,
                            CYAN_MAILBOX, PURPLE_MAILBOX, BLUE_MAILBOX, BROWN_MAILBOX,
                            GREEN_MAILBOX, RED_MAILBOX, BLACK_MAILBOX, WHITE_MAILBOX)
                    .build(null).setRegistryName("mailbox");
}
